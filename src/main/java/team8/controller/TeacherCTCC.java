package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.CTCDAO;
import team8.dao.impl.CTCImpl;
import team8.model.CTC;
import team8.model.Teacher;

import java.io.IOException;

public class TeacherCTCC {
    static Teacher teacher;
    static Stage stage = new Stage();

    public Button AddCTCB;
    public Button BackB;
    public TableColumn BNameT;
    public TableColumn ISBNT;
    public TableColumn CourseT;
    public TableColumn ClassT;
    public TableView CTCT;
    public TableColumn UpdateT;

    /**
     * 教师查看任课安排 控制器
     * Author:zPolari
     * Time:2020-12-20
     */



    public void Back(ActionEvent actionEvent) {
        new TeacherUIC().start(teacher);
        stage.close();

    }

    public void AddTechbook(ActionEvent actionEvent) {
        new TechBookForm().start(teacher);
        stage.close();

    }

    void showTable() {
        CTCDAO ctcdao = new CTCImpl();
        ObservableList<CTC> list = FXCollections.observableArrayList(ctcdao.findByUnion(teacher.getUnionID()));


        ClassT.setCellValueFactory(new PropertyValueFactory("ClassName"));
        CourseT.setCellValueFactory(new PropertyValueFactory("CourseName"));
        ISBNT.setCellValueFactory(new PropertyValueFactory("ISBN"));
        BNameT.setCellValueFactory(new PropertyValueFactory("BName"));

        UpdateT.setCellFactory((col) -> {
                    TableCell<Teacher, String> cell = new TableCell<Teacher, String>() {

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            Button button2 = new Button("修改");
                            button2.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                            button2.setOnMouseClicked((col) -> {
                                CTC ctc = list.get(getIndex());
                                new UpdateCTCC().start(ctc, teacher);
                                stage.close();

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
        CTCT.setItems(list);

    }

    @FXML
    void initialize() {
        showTable();
    }


    void start(Teacher t) {
        teacher = t;
        stage.setTitle("新增教师窗口");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TeacherCTC.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();


    }
}
