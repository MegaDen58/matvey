package com.example.auto;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserView {
    @FXML
    private TextField ageField;

    @FXML
    private Button calcButton;

    @FXML
    private TextField experienceField;

    @FXML
    private ComboBox<String> kbmMenu;

    @FXML
    private TextField powerField;
    @FXML
    private ComboBox<String> ogranDrivers;

    @FXML
    private ComboBox<String> registrationMenu;

    @FXML
    private ComboBox<String> seasonMenu;

    @FXML
    private CheckBox taxiCheck;

    public static double T;
    private int TB = 0;
    private double KO, KS, KBM, KVS, KT, KM;

    @FXML
    void Calculate() throws Exception{

        int age = Integer.parseInt(ageField.getText());
        int experience = Integer.parseInt(experienceField.getText());
        int power = Integer.parseInt(powerField.getText());

        if(taxiCheck.isSelected()){
            TB = 5790;
        }
        else{
            TB = 3650;
        }

        KO = Double.parseDouble(ogranDrivers.getValue().split("\\s{2,100}")[1]);
        KS = Double.parseDouble(seasonMenu.getValue().split("\\s{2,100}")[1]);
        KBM = Double.parseDouble(kbmMenu.getValue().split("кбм")[1].replaceAll("\\)", ""));

        String[] array = {
                "1617182021   0=2.27 1=1.92 2=1.84 3=1.65 4=1.65 5=1.62 6=1.62",
                "222324   0=1.88 1=1.72 2=1.71 3=1.13 4=1.13 5=1.1 6=1.1 7=1.09 8=1.09 9=1.09",
                "2526272829   0=1.72 1=1.6 2=1.54 3=1.09 4=1.09 5=1.08 6=1.08 7=1.07 8=1.07 9=1.07 10=1.02 11=1.02 12=1.02 13=1.02 14=1.02",
                "3031323334   0=1.56 1=1.5 2=1.48 3=1.05 4=1.05 5=1.04 6=1.04 7=1.01 8=1.01 9=1.01 10=0.97 11=0.97 12=0.97 13=0.97 14=0.97-0.95",
                "3536373839   0=1.54 1=1.47 2=1.46 3=1 4=1 5=0.97 6=0.97 7=0.95 8=0.95 9=0.95 10=0.94 11=0.94 12=0.94 13=0.94 14=0.94-0.93",
                "404142434445474849   0=1.5 1=1.44 2=1.43 3=0.96 4=0.96 5=0.95 6=0.95 7=0.94 8=0.94 9=0.94 10=0.93 11=0.93 12=0.93 13=0.93 14=0.93-0.91",
                "50515253545556575859   0=1.46 1=1.4 2=1.39 3=0.93 4=0.93 5=0.92 6=0.92 7=0.91 8=0.91 9=0.91 10=0.9 11=0.9 12=0.9 13=0.9 14=0.9-0.86",
                "0=1.43 1=1.36 2=1.35 3=0.91 4=0.91 5=0.9 6=0.9 7=0.89 8=0.89 9=0.89 10=0.88 11=0.88 12=0.88 13=0.88 14=0.88-0.83"
        };

        KVS = getKef(age, experience, array);
        KT = Double.parseDouble(registrationMenu.getValue().split("\\s{2,100}")[1]);
        KM = getPowerKef(power);

        T = TB * KT * KBM * KVS * KO * KM * KS;

        Stage stageToClose = (Stage) calcButton.getScene().getWindow();
        stageToClose.close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("result-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setTitle("Authorization");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        for(String text : Adapter.cities){
            registrationMenu.getItems().addAll(text);
        }
        for(String text : Adapter.months){
            seasonMenu.getItems().addAll(text);
        }
        for(String text : Adapter.kbmArray){
            kbmMenu.getItems().addAll(text);
        }
        for(String text : Adapter.drivers){
            ogranDrivers.getItems().addAll(text);
        }
    }

    public static double getKef(int age, int experience, String[] array){
        double kef = 0;
        if(age > 59){
            if(experience > 14){
                kef = Double.parseDouble(array[array.length - 1].split("-")[1]);
            }
            else{
                String[] ex = array[array.length - 1].split(" ");
                for(String ex1 : ex){
                    if(ex1.contains(String.valueOf(age))){
                        kef = Double.parseDouble(ex1.split("=")[1]);
                    }
                }
            }
        }
        for(String text : array){
            String[] text1 = text.split("   ");
            if(text1[0].contains(String.valueOf(age))){
                if(experience > 14){
                    kef = Double.parseDouble(text1[0].split("-")[1]);
                }
                else{
                    String[] text2 = text1[1].split(" ");
                    for(String text3 : text2){
                        if(text3.contains(String.valueOf(experience))){
                            if(text3.split("=")[1].contains("-")){
                                kef = Double.parseDouble(text3.split("=")[1].split("-")[0]);
                                return kef;
                            }
                            else{
                                kef = Double.parseDouble(text3.split("=")[1]);
                                return kef;
                            }
                        }
                    }
                }
            }
        }
        return kef;
    }

    public static double getPowerKef(int power){
        double result = 0;
        if(power <= 50){
            result = 0.6;
        }
        if(power >= 51 && power <= 70){
            result = 1;
        }
        if(power >= 71 && power <= 100){
            result = 1.1;
        }
        if(power >= 101 && power <= 120){
            result = 1.2;
        }
        if(power >= 121 && power <= 150){
            result = 1.4;
        }
        if(power > 150){
            result = 1.6;
        }
        return result;
    }

}