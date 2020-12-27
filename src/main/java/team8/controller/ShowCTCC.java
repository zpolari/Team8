package team8.controller;
import team8.dao.CTCDAO;
import team8.dao.impl.CTCImpl;
import team8.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * 任课安排窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */


public class ShowCTCC {

    @FXML
    TableView CTCT;
    @FXML
    TableColumn ClassT;
    @FXML
    TableColumn CourseT;
    @FXML
    TableColumn TeacherT;
    @FXML
    TableColumn BNameT;
    @FXML
    TableColumn DelT;

    @FXML
    Button BackB;
    @FXML
    Button AddCTCB;


    static Stage stage = new Stage();


    @FXML
    void Back(ActionEvent actionEvent) {
        stage.close();
        new SecretaryUIC().start();
    }


    //
    @FXML
    void OpenAddCTC(ActionEvent actionEvent) {

        new AddCTCC().start();
        stage.close();
    }

    /**
     * 向列表中的列添加按钮
     * Author:zPolari
     * Time:2020-12-20
     */
    void showTable() {
        CTCDAO ctcdao = new CTCImpl();
        ObservableList<CTC> list = FXCollections.observableArrayList(ctcdao.findByUnion("all"));
        ClassT.setCellValueFactory(new PropertyValueFactory("ClassName"));
        CourseT.setCellValueFactory(new PropertyValueFactory("CourseName"));
        TeacherT.setCellValueFactory(new PropertyValueFactory("TeachName"));
        BNameT.setCellValueFactory(new PropertyValueFactory("BName"));



        DelT.setCellFactory((col) -> {
                    TableCell<Teacher, String> cell = new TableCell<Teacher, String>() {

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            //按钮显示文字
                            Button button2 = new Button("删除");
                            //设置按钮颜色
                            button2.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                            //按钮点击事件
                            button2.setOnMouseClicked((col) -> {
                                //获取list列表中的位置，进而获取列表对应的信息数据
                                CTC ctc = list.get(getIndex());
                                System.out.println(new CTCImpl().delCTC(ctc));
                                showTable();
                            });

                            if (empty) {
                                //如果此列为空默认不添加元素
                                setText(null);
                                setGraphic(null);
                            } else {
                                //加载按钮
                                this.setGraphic(button2);
                            }
                        }
                    };
                    return cell;
                }
        );


        CTCT.setItems(list);


    }


    @FXML
    void initialize() {
        showTable();
    }

    void start() {
        stage.setTitle("任课安排查看");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/ShowCTC.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();
    }



}
