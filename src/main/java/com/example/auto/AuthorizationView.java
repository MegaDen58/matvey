package com.example.auto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthorizationView {

    @FXML
    private Button authAdminButton;

    @FXML
    private TextField loginField;
    @FXML private Label errorText;

    @FXML
    private PasswordField passwordField;
    String log = "admin", pass = "12345";

    @FXML
    void adminEnterButton() throws Exception{
        if(!passwordField.getText().equals(pass) || !loginField.getText().equals(log)){
            errorText.setText("Ошибка.");
        }
        else{
            Stage stageToClose  = (Stage) authAdminButton.getScene().getWindow();
            stageToClose.close();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("administrator-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 500);
            stage.setTitle("Authorization");
            stage.setScene(scene);
            stage.show();
        }
    }

}
