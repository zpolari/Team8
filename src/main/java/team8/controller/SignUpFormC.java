package team8.controller;
import team8.dao.impl.LoginImpl;
import team8.model.Secretary;
import team8.model.Teacher;

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

import java.io.IOException;
import java.util.Random;

/**
 * 注册窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */

public class SignUpFormC {

    @FXML Label WhoLabel;
    @FXML
    Button SignUpButton;
    @FXML
    Label MsgLabel;
    @FXML
    Button BackButton;
    @FXML
    TextField usernameText;
    @FXML
    TextField ageText;
    @FXML
    TextField accountText;
    @FXML
    TextField passwordText;
    @FXML
    TextField phoneText;
    static String whoIs;
    static Stage stage = new Stage();

    public static String getUnionID(int length){
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public void start(String who) {
        whoIs=who;
        stage.setTitle("注册窗口");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/SignUpForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(StartFormC.GlobalSetResizable);
        stage.show();

    }

    @FXML
    void Back(ActionEvent actionEvent) {
        stage.close();
        LoginFormC.stage.show();
    }

    @FXML
    void initialize() {
        WhoLabel.setText("欢迎来到" + whoIs + "新增界面");

    }

    @FXML
    void SignUP(ActionEvent actionEvent) {

        if (usernameText.getText().equals("")||passwordText.getText().equals("")){
            MsgLabel.setText("请填写带*号项");
            return;
        }

        if (whoIs.equals("教师")){
            MsgLabel.setText(new LoginImpl().teacherSignUp(new Teacher(getUnionID(9),accountText.getText(),passwordText.getText(),usernameText.getText(),ageText.getText(),phoneText.getText())));
        }

        if (whoIs.equals("教学秘书")){
            MsgLabel.setText(new LoginImpl().secretarySignUp(new Secretary(getUnionID(9),accountText.getText(),passwordText.getText(),usernameText.getText(),ageText.getText(),phoneText.getText())));

        }
    }


}
