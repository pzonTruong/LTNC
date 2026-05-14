import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Controller {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private ToggleGroup genderGroup;
    @FXML private ComboBox<String> majorComboBox;
    @FXML private CheckBox codingCheck;
    @FXML private CheckBox musicCheck;
    @FXML private CheckBox sportsCheck;
    @FXML private Label statusLabel;

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
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        // Reset styles and status
        clearErrorStyles();
        statusLabel.setText("");
        statusLabel.getStyleClass().removeAll("status-success", "status-error");

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
        String major = majorComboBox.getValue();

        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();

        // Validation logic
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

        // Collect interests
        List<String> interests = new ArrayList<>();
        if (codingCheck.isSelected()) interests.add("Coding");
        if (musicCheck.isSelected()) interests.add("Music");
        if (sportsCheck.isSelected()) interests.add("Sports");

        // Create Model
        Student student = new Student(name, email, selectedGender.getText(), major, interests);
        
        // Success Feedback
        statusLabel.setText("Registration Successful for " + student.getFullName() + "!");
        statusLabel.getStyleClass().add("status-success");
        
        System.out.println("New Student Created: " + student);
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
