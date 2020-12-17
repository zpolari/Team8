package team8.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import team8.dao.impl.CTCImpl;
import team8.dao.impl.TeacherImpl;
import team8.model.CTC;
import team8.model.ClassC;
import team8.model.Course;
import team8.model.Teacher;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

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
    Button BackB;
    @FXML
    Button AddCTC;

    static String unionID;

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


    void setCourse(String c) {
        courseC.setItems(FXCollections.observableArrayList(Course.findClassNoSelect(c)));
    }


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

    @FXML
    void initialize() {
        setClass();
        setTeacher();
    }

    void start() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/FXML/AddCTC.fxml"));
            stage.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                new ShowCTCC().start();

                stage.close();
            }
        });

        stage.show();
    }


}
