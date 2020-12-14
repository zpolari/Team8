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
import java.util.Random;

public class SingUpFormC {

    @FXML Label WhoLabel;
    @FXML
    Button SingUpButton;
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

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/SingUpForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
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
    void SingUP(ActionEvent actionEvent) {

        if (usernameText.getText().equals("")||passwordText.getText().equals("")){
            MsgLabel.setText("请填写带*号项");
            return;
        }

        if (whoIs.equals("教师")){
            MsgLabel.setText(new LoginImpl().teacherSingUp(new Teacher(getUnionID(9),accountText.getText(),passwordText.getText(),usernameText.getText(),ageText.getText(),phoneText.getText())));
        }

        if (whoIs.equals("教学秘书")){
            MsgLabel.setText(new LoginImpl().secretarySingUp(new Secretary(getUnionID(9),accountText.getText(),passwordText.getText(),usernameText.getText(),ageText.getText(),phoneText.getText())));

        }
    }


}
