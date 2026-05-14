import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private ComboBox<String> majorComboBox;

    @FXML
    private CheckBox codingCheck;

    @FXML
    private CheckBox musicCheck;

    @FXML
    private CheckBox sportsCheck;

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
        String name = nameField.getText();
        String email = emailField.getText();
        RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
        String gender = (selectedGender != null) ? selectedGender.getText() : "Not specified";
        String major = majorComboBox.getValue();

        if (name.isEmpty() || email.isEmpty() || major == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all required fields!");
            return;
        }

        StringBuilder interests = new StringBuilder();
        if (codingCheck.isSelected()) interests.append("Coding ");
        if (musicCheck.isSelected()) interests.append("Music ");
        if (sportsCheck.isSelected()) interests.append("Sports ");

        String message = String.format("Name: %s\nEmail: %s\nGender: %s\nMajor: %s\nInterests: %s",
                name, email, gender, major, interests.toString().trim());

        showAlert(Alert.AlertType.INFORMATION, "Registration Successful", message);
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
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
