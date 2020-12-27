package team8.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.model.Teacher;

import java.io.IOException;

/**
 * 任课教师 用户界面窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */



public class TeacherUIC {

    static Stage stage = new Stage();
    static Teacher teacher = new Teacher();

    @FXML
    Button CTCB;
    @FXML
    Button BackB;
    @FXML
    Button TechbookB;
    @FXML
    Button InfoB;
    @FXML
    Label InfoLabel;

    @FXML
    void showCTC(ActionEvent actionEvent) {

        stage.close();
        new TeacherCTCC().start(teacher);

    }


    @FXML
    void showTechbook(ActionEvent actionEvent) {
        new TechBookForm().start(teacher);
        stage.close();
    }

    @FXML
    void UpdateInfo(ActionEvent actionEvent) {

        new TeacherEditC().start(teacher, false);

    }


    @FXML
    void initialize() {
        InfoLabel.setText("你好：" + teacher.getName() + "  老师");
    }

    void start(Teacher t) {
        teacher = t;
        stage.setTitle("任课教师菜单");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TeacherUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/CSS/teacherUI.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(StartFormC.GlobalSetResizable);
        stage.show();
    }

    @FXML
    void back(ActionEvent actionEvent) {
        stage.close();
    }
}
