package com.example.auto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UserView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageField;

    @FXML
    private Button calcButton;

    @FXML
    private TextField experienceField;

    @FXML
    private ComboBox<?> kbmMenu;

    @FXML
    private TextField powerField;

    @FXML
    private ComboBox<?> registrationMenu;

    @FXML
    private ComboBox<?> seasonMenu;

    @FXML
    private CheckBox taxiCheck;

    @FXML
    void Calculate(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}