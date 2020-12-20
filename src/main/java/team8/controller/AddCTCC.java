package team8.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import team8.dao.impl.CTCImpl;
import team8.dao.impl.TeacherImpl;
import team8.model.CTC;
import team8.model.ClassC;
import team8.model.Course;
import team8.model.Teacher;

import java.io.IOException;

import java.util.ArrayList;

/**
 * 新增任课安排窗口 控制器
 * FXML NODE：MsgLabel、classC、courseC、teacherC、AddCTC
 * FXML Func:addBack、AddCTC
 * Author:zPolari
 * Time:2020-12-18
 */

public class AddCTCC {
    static Stage stage = new Stage();

    @FXML
    Label MsgLabel;
    @FXML
    ComboBox classC;
    @FXML
    ComboBox courseC;
    @FXML
    ComboBox teacherC;
    @FXML
    Button AddCTC;

    static String unionID;

    /**
     * 方法作用：新增一个任课安排
     * 使用courseC、classC、teacherC信息 创建一个CTC对象
     * 使用Impl 向数据库新增任课安排
     * Author:zPolari
     * Time:2020-12-18
     */

    @FXML
    void AddCTC(ActionEvent actionEvent) {
        CTC ctc = new CTC();

        if (courseC.getSelectionModel().getSelectedIndex()==-1 || classC.getSelectionModel().getSelectedIndex()==-1  ||teacherC.getSelectionModel().getSelectedIndex()==-1){
            MsgLabel.setText("请选择所有选项");
        }

        ctc.setClassName(classC.getSelectionModel().getSelectedItem().toString());
        ctc.setCourseName(courseC.getSelectionModel().getSelectedItem().toString());
        ctc.setUnionID(unionID);

        MsgLabel.setText(new CTCImpl().addCTC(ctc));
        setCourse(classC.getSelectionModel().getSelectedItem().toString());

    }



    @FXML
    void addBack(ActionEvent actionEvent) {
        new ShowCTCC().start();
        stage.close();
    }

    /**
     * 方法作用：设置课程选择器
     * 根据所选班级 调用Impl 进行差集运算
     * 将未安排的课程装载进 课程选择器
     * 方便教学秘书选择课程
     * Author:zPolari
     * Time:2020-12-19
     */
    void setCourse(String c) {
        courseC.setItems(FXCollections.observableArrayList(Course.findClassNoSelect(c)));
    }

    /**
     * 方法作用：设置班级选择器
     * 装入所有班级
     * 且新增选定监听器
     * 使教学秘书选择完班级后自动调用
     * 设置课程方法 来进行课程设置
     * Author:zPolari
     * Time:2020-12-19
     */
    void setClass() {
        ObservableList<String> list = FXCollections.observableArrayList(ClassC.GetClass());
        classC.setItems(list);
        classC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(classC.getSelectionModel().getSelectedItem().toString());

                setCourse(classC.getSelectionModel().getSelectedItem().toString());
            }
        });

    }

    void setTeacher() {
        ArrayList<Teacher> arrayList = new TeacherImpl().findAll();
        ArrayList<String> teacher = new ArrayList<>();

        for (Teacher t : arrayList
        ) {
            teacher.add(t.getName());
        }

        ObservableList<String> list = FXCollections.observableArrayList(teacher);
        teacherC.setItems(list);

        teacherC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ArrayList<Teacher> arrayList = new TeacherImpl().findAll();
                unionID=arrayList.get(teacherC.getSelectionModel().getSelectedIndex()).getUnionID();
            }
        });

    }

    /**
     * 方法作用：启动窗口后 进行相关初始化
     * Author:zPolari
     * Time:2020-12-19
     */
    @FXML
    void initialize() {
        setClass();
        setTeacher();
    }

    /**
     * 方法作用：启动窗口 加载对应FXML
     * Author:zPolari
     * Time:2020-12-19
     */
    void start() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/FXML/AddCTC.fxml"));
            stage.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setOnCloseRequest(event -> {
            new ShowCTCC().start();
            stage.close();
        });

        stage.show();
    }


}
