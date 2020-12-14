package team8.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SecretaryUIC {
    @FXML
    Button TeacherControllerButton;
    @FXML
    Button TechBookButton;

    static Stage stage = new Stage();

    @FXML
    void TechBookShow(ActionEvent actionEvent) {
        stage.close();
        new TechBookForm().start();

    }

    @FXML
    void TeacherShow(ActionEvent actionEvent) {
        stage.hide();
        new TeacherInfoFormC().start();
    }


    void start() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/SecretaryUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void AddCTC(ActionEvent actionEvent) {

        Stage AddCTCStage =new Stage();
        try {
            Parent parent=FXMLLoader.load(getClass().getResource("/FXML/AddCTC.fxml"));
            AddCTCStage.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCTCStage.show();


    }
}
