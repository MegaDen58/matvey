package com.example.auto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorView implements Initializable {
    @FXML
    ComboBox<String> ageCombo, experienceCombo, powerCombo, placeCombo, seasonCombo, baseCombo, driversCombo, KBMCombo;
    @FXML
    TextField ageField, experienceField, powerField, placeField, seasonField, baseField, driversField, KBMField;

    public void Calculate() {
        if(!placeCombo.getValue().isEmpty() && !placeField.getText().isEmpty()){
            String newText;
            String combo = placeCombo.getValue();
            String field = placeField.getText();
            String[] cc = combo.split("\\s{2,100}");
            cc[1] = field;
            System.out.println(arrayToString(cc));

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(String text : Adapter.cities){
            placeCombo.getItems().addAll(text);
        }
        for(String text : Adapter.months){
            seasonCombo.getItems().addAll(text);
        }
        for(String text : Adapter.kbmArray){
            KBMCombo.getItems().addAll(text);
        }
        for(String text : Adapter.drivers){
            driversCombo.getItems().addAll(text);
        }
    }

    public String arrayToString(String[] array){
        String result = "";
        for(String text : array){
            result += text + " ";
            result.trim();
        }
        return result;
    }
}
