package team8.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.impl.LoginImpl;
import team8.model.Secretary;
import team8.model.Teacher;

import java.io.IOException;

public class LoginFormC {
    @FXML
    Label whoIsLogin;
    @FXML
    Button BackButton;
    @FXML
    TextField UserNameText;
    @FXML
    TextField PasswordText;
    @FXML
    Button SingUPButton;
    @FXML
    Button SingINButton;
    @FXML
    Label MsgLabel;

    static String whoIs;
    public static Stage stage = new Stage();
    static Secretary secretary=null;
    static Teacher teacher=null;


    @FXML
    void Back(ActionEvent actionEvent) {
        stage.close();
        new StartFormC().start();
    }

    @FXML
    void SingUP(ActionEvent actionEvent) {
        stage.hide();
        new SingUpFormC().start(whoIs);

    }

    @FXML
    void SingIN(ActionEvent actionEvent) {

        if (whoIs.equals("教师")){
             teacher=new LoginImpl().teacherLogin(UserNameText.getText(),PasswordText.getText());
            System.out.println(teacher);
            if (teacher==null){
                MsgLabel.setText("登录失败");

            }else {
                MsgLabel.setText("登录成功");
            }

        }

        if (whoIs.equals("教学秘书")){
            secretary=new LoginImpl().secretaryLogin(UserNameText.getText(),PasswordText.getText());
            System.out.println(secretary);
            if (secretary==null){
                MsgLabel.setText("登录失败");

            }else {
                MsgLabel.setText("登录成功");
                stage.close();
                new SecretaryUIC().start();
            }

        }

    }


    @FXML
    void initialize() {
        whoIsLogin.setText("欢迎来到" + whoIs + "登录界面");

    }


    public void start(String who) {

        whoIs = who;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/LoginForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();

    }


}
