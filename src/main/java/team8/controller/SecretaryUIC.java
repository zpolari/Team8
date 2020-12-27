package team8.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.model.Secretary;

import java.io.IOException;

/**
 * 教学秘书窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */


public class SecretaryUIC {
    public Button AddCTCB;
    @FXML
    Button TeacherControllerButton;
    @FXML
    Button TechBookButton;

    static Stage stage = new Stage();

    @FXML
    void TechBookShow(ActionEvent actionEvent) {
        stage.close();
        new TechBookForm().start(new Secretary());

    }

    @FXML
    void TeacherShow(ActionEvent actionEvent) {
        stage.hide();
        new TeacherInfoFormC().start();
    }



    void start() {
        Parent root = null;
        stage.setTitle("教学秘书菜单");

        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/SecretaryUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/CSS/secretaryUI.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();
    }


@FXML
     void ShowCTC(ActionEvent actionEvent) {
        stage.close();
        new ShowCTCC().start();
    }
}
