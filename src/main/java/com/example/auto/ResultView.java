package com.example.auto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultView {
    @FXML
    Label result;
    @FXML Button exitButton;

    @FXML
    void Exit() throws Exception{
        Stage stageToClose  = (Stage) exitButton.getScene().getWindow();
        stageToClose.close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setTitle("Authorization");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {

        result.setText(String.format("%.2f", UserView.T) + "руб.");
    }

}
