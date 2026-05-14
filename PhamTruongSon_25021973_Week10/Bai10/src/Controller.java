import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Controller {

    @FXML private VBox rootVBox;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private ToggleGroup genderGroup;
    @FXML private ComboBox<String> majorComboBox;
    @FXML private CheckBox codingCheck;
    @FXML private CheckBox musicCheck;
    @FXML private CheckBox sportsCheck;
    @FXML private Label statusLabel;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Button submitButton, saveButton, loadButton, clearButton;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @FXML
    public void initialize() {
        // Populate major choices
        majorComboBox.setItems(FXCollections.observableArrayList(
            "Computer Science", 
            "Information Technology", 
            "Business Administration", 
            "Graphic Design",
            "English Literature"
        ));

        setupRealTimeValidation();
        setupKeyboardEvents();
    }

    private void setupRealTimeValidation() {
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            validateName(newValue);
        });

        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(newValue);
        });
    }

    private void validateName(String value) {
        if (value == null || value.trim().isEmpty()) {
            nameField.getStyleClass().add("error-field");
        } else {
            nameField.getStyleClass().remove("error-field");
        }
    }

    private void validateEmail(String value) {
        if (value == null || value.trim().isEmpty() || !Pattern.matches(EMAIL_REGEX, value)) {
            emailField.getStyleClass().add("error-field");
        } else {
            emailField.getStyleClass().remove("error-field");
        }
    }

    private void setupKeyboardEvents() {
        // Enter key navigation
        nameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                emailField.requestFocus();
            }
        });

        emailField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                majorComboBox.requestFocus();
            }
        });

        // Global shortcut Ctrl+S
        Platform.runLater(() -> {
            if (rootVBox.getScene() != null) {
                rootVBox.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    if (event.isControlDown() && event.getCode() == KeyCode.S) {
                        handleSave(null);
                        event.consume();
                    }
                });
            }
        });
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        clearErrorStyles();
        statusLabel.setText("");
        statusLabel.getStyleClass().removeAll("status-success", "status-error");

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
        String major = majorComboBox.getValue();

        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();

        if (name.isEmpty()) {
            nameField.getStyleClass().add("error-field");
            errorMsg.append("Name is required. ");
            hasError = true;
        }

        if (email.isEmpty()) {
            emailField.getStyleClass().add("error-field");
            errorMsg.append("Email is required. ");
            hasError = true;
        } else if (!Pattern.matches(EMAIL_REGEX, email)) {
            emailField.getStyleClass().add("error-field");
            errorMsg.append("Invalid email format. ");
            hasError = true;
        }

        if (selectedGender == null) {
            errorMsg.append("Gender is required. ");
            hasError = true;
        }

        if (major == null) {
            majorComboBox.getStyleClass().add("error-field");
            errorMsg.append("Major selection is required. ");
            hasError = true;
        }

        if (hasError) {
            statusLabel.setText(errorMsg.toString().trim());
            statusLabel.getStyleClass().add("status-error");
            return;
        }

        List<String> interests = new ArrayList<>();
        if (codingCheck.isSelected()) interests.add("Coding");
        if (musicCheck.isSelected()) interests.add("Music");
        if (sportsCheck.isSelected()) interests.add("Sports");

        Student student = new Student(name, email, selectedGender.getText(), major, interests);
        statusLabel.setText("Registration Successful for " + student.getFullName() + "!");
        statusLabel.getStyleClass().add("status-success");
    }

    @FXML
    void handleSave(ActionEvent event) {
        clearErrorStyles();
        statusLabel.setText("");
        statusLabel.getStyleClass().removeAll("status-success", "status-error");

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
        String major = majorComboBox.getValue();

        if (name.isEmpty() || email.isEmpty() || selectedGender == null || major == null) {
            statusLabel.setText("Please fill all required fields before saving.");
            statusLabel.getStyleClass().add("status-error");
            return;
        }

        List<String> interests = new ArrayList<>();
        if (codingCheck.isSelected()) interests.add("Coding");
        if (musicCheck.isSelected()) interests.add("Music");
        if (sportsCheck.isSelected()) interests.add("Sports");

        Student student = new Student(name, email, selectedGender.getText(), major, interests);

        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate network/db delay
                Thread.sleep(1500);
                student.save();
                return null;
            }
        };

        saveTask.setOnRunning(e -> {
            setLoading(true);
            statusLabel.setText("Saving data to database...");
        });

        saveTask.setOnSucceeded(e -> {
            setLoading(false);
            statusLabel.setText("Data saved successfully to Database!");
            statusLabel.getStyleClass().add("status-success");
        });

        saveTask.setOnFailed(e -> {
            setLoading(false);
            Throwable ex = saveTask.getException();
            statusLabel.setText("Database Error: " + ex.getMessage());
            statusLabel.getStyleClass().add("status-error");
            ex.printStackTrace();
        });

        new Thread(saveTask).start();
    }

    @FXML
    void handleLoad(ActionEvent event) {
        Task<Student> loadTask = new Task<>() {
            @Override
            protected Student call() throws Exception {
                Thread.sleep(1500); // Simulate delay
                return Student.loadLatest();
            }
        };

        loadTask.setOnRunning(e -> {
            setLoading(true);
            statusLabel.setText("Loading latest record...");
        });

        loadTask.setOnSucceeded(e -> {
            setLoading(false);
            Student student = loadTask.getValue();
            if (student != null) {
                populateForm(student);
                statusLabel.setText("Latest record loaded from Database.");
                statusLabel.getStyleClass().add("status-success");
            } else {
                statusLabel.setText("No records found in Database.");
                statusLabel.getStyleClass().add("status-error");
            }
        });

        loadTask.setOnFailed(e -> {
            setLoading(false);
            Throwable ex = loadTask.getException();
            statusLabel.setText("Error loading data: " + ex.getMessage());
            statusLabel.getStyleClass().add("status-error");
            ex.printStackTrace();
        });

        new Thread(loadTask).start();
    }

    private void populateForm(Student student) {
        nameField.setText(student.getFullName());
        emailField.setText(student.getEmail());
        
        for (Toggle toggle : genderGroup.getToggles()) {
            RadioButton rb = (RadioButton) toggle;
            if (rb.getText().equals(student.getGender())) {
                genderGroup.selectToggle(rb);
                break;
            }
        }

        majorComboBox.setValue(student.getMajor());
        codingCheck.setSelected(student.getInterests().contains("Coding"));
        musicCheck.setSelected(student.getInterests().contains("Music"));
        sportsCheck.setSelected(student.getInterests().contains("Sports"));
    }

    private void setLoading(boolean loading) {
        progressIndicator.setVisible(loading);
        submitButton.setDisable(loading);
        saveButton.setDisable(loading);
        loadButton.setDisable(loading);
        clearButton.setDisable(loading);
        nameField.setDisable(loading);
        emailField.setDisable(loading);
    }

    @FXML
    void handleClear(ActionEvent event) {
        nameField.clear();
        emailField.clear();
        genderGroup.selectToggle(null);
        majorComboBox.setValue(null);
        codingCheck.setSelected(false);
        musicCheck.setSelected(false);
        sportsCheck.setSelected(false);
        statusLabel.setText("");
        clearErrorStyles();
    }

    private void clearErrorStyles() {
        nameField.getStyleClass().remove("error-field");
        emailField.getStyleClass().remove("error-field");
        majorComboBox.getStyleClass().remove("error-field");
    }
}
