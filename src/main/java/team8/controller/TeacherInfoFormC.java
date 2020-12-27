package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.impl.TeacherImpl;
import team8.model.Teacher;

import java.io.IOException;

/**
 * 任课教师信息查看窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */



public class TeacherInfoFormC {
    static Stage stage = new Stage();
    @FXML
    Button addTeacherB;
    @FXML
    Button BackB;
    @FXML
    Label MsgLabel;
    @FXML
    TableView TeacherTable;
    @FXML
    TableColumn UnionID;
    @FXML
    TableColumn Account;
    @FXML
    TableColumn Password;
    @FXML
    TableColumn Name;
    @FXML
    TableColumn Telephone;
    @FXML
    TableColumn Age;
    @FXML
    TableColumn Edit;
    @FXML
    TableColumn Del;


    private void showList() {
        ObservableList<Teacher> list = FXCollections.observableArrayList(new TeacherImpl().findAll());

        UnionID.setCellValueFactory(new PropertyValueFactory("UnionID"));
        Account.setCellValueFactory(new PropertyValueFactory("Account"));
        Password.setCellValueFactory(new PropertyValueFactory("Password"));
        Name.setCellValueFactory(new PropertyValueFactory("Name"));
        Telephone.setCellValueFactory(new PropertyValueFactory("Telephone"));
        Age.setCellValueFactory(new PropertyValueFactory("Age"));

        Edit.setCellFactory((col) -> {

                    //UserLoad换成你自己的实体名称
                    TableCell<Teacher, String> cell = new TableCell<Teacher, String>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            Button button1 = new Button("编辑");
                            button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                            button1.setOnMouseClicked((col) -> {

                                //获取list列表中的位置，进而获取列表对应的信息数据
                                Teacher teacher = list.get(getIndex());
                                //按钮事件自己添加
                                new TeacherEditC().start(teacher, true);
                                stage.close();
                            });

                            if (empty) {
                                //如果此列为空默认不添加元素
                                setText(null);
                                setGraphic(null);
                            } else {
                                this.setGraphic(button1);
                            }
                        }
                    };
                    cell.setAlignment(Pos.CENTER);

                    return cell;
                }
        );

        Del.setCellFactory((col) -> {
                    TableCell<Teacher, String> cell = new TableCell<Teacher, String>() {

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            Button button2 = new Button("删除");
                            button2.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                            button2.setOnMouseClicked((col) -> {
                                Teacher teacher = list.get(getIndex());
                                if (new TeacherImpl().delTeacher(teacher.getUnionID())) {
                                    MsgLabel.setText("此老师有课程安排，无法删除");
                                    return;
                                }

                                showList();
                            });

                            if (empty) {
                                setText(null);
                                setGraphic(null);
                            } else {
                                this.setGraphic(button2);
                            }
                        }
                    };
                    cell.setAlignment(Pos.CENTER);

                    return cell;
                }
        );


        TeacherTable.setItems(list);

    }

    @FXML
    void initialize() {
        showList();
    }

    void start() {
        Parent root = null;
        stage.setTitle("教师信息查看窗");

        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TeacherInfoForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();
    }


    public void AddTeacher(ActionEvent actionEvent) {
        new TeacherEditC().start(new Teacher(), true);
        stage.close();
    }

    public void Back(ActionEvent actionEvent) {
        SecretaryUIC.stage.show();
        stage.close();
    }
}
