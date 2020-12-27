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
import team8.dao.impl.TeacherImpl;
import team8.model.Teacher;

import java.io.IOException;

/**
 * 任课教师信息编辑窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */



public class TeacherEditC {
    static Stage stage = new Stage();
    static Teacher teacher=new Teacher();
    static boolean aBoolean;

    @FXML Button BackB;
    @FXML Label UnionIDL;
    @FXML TextField UnionIDT;
    @FXML TextField AccountT;
    @FXML TextField NameT;
    @FXML TextField PhoneT;
    @FXML TextField PWT;
    @FXML TextField AgeT;
    @FXML Button AddB;
    @FXML Button SaveB;
    @FXML Label MsgLabel;
    @FXML Label TitleLabel;



    public void Back(ActionEvent actionEvent) {
        stage.close();
        if (aBoolean){
            new TeacherInfoFormC().start();
        }else {
            new TeacherUIC().start(teacher);
        }
    }

    public void Add(ActionEvent actionEvent) {

        UnionIDT.setText(SignUpFormC.getUnionID(9));
        MsgLabel.setText(new TeacherImpl().addTeacher(new Teacher(UnionIDT.getText(),AccountT.getText(),PWT.getText(),NameT.getText(),AgeT.getText(),PhoneT.getText())));

    }

    public void Save(ActionEvent actionEvent) {
        teacher=new Teacher(UnionIDT.getText(),AccountT.getText(),PWT.getText(),NameT.getText(),AgeT.getText(),PhoneT.getText());
        MsgLabel.setText(new TeacherImpl().updateTeacher(teacher));

    }

    @FXML
    void initialize(){

        if (teacher.getUnionID()==null){
            TitleLabel.setText("新增老师信息");

            SaveB.setVisible(false);
            UnionIDL.setVisible(false);
            UnionIDT.setVisible(false);

        }else {
            AddB.setVisible(false);
            TitleLabel.setText("修改："+teacher.getName()+"  老师信息");

            UnionIDT.setEditable(false);
            UnionIDT.setText(teacher.getUnionID());
            AccountT.setText(teacher.getAccount());
            PWT.setText(teacher.getPassword());
            NameT.setText(teacher.getName());
            AgeT.setText(teacher.getAge());
            PhoneT.setText(teacher.getTelephone());


        }

    }

    void start(Teacher t,boolean b){
        teacher=t;
        aBoolean=b;
        stage.setTitle("教师信息编辑窗");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TeacherEditForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/CSS/teacherEdit.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(StartFormC.GlobalSetResizable);
        stage.show();

    }


}
