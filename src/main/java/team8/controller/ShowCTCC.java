package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import team8.dao.impl.TeacherImpl;
import team8.model.Books;
import team8.model.CTC;
import team8.model.Teacher;

import java.io.IOException;
import java.util.ArrayList;

public class ShowCTCC {

    @FXML TableView CTCT;
    @FXML TableColumn ClassT;
    @FXML TableColumn CourseT;
    @FXML TableColumn TeacherT;
    @FXML TableColumn BNameT;
    @FXML TableColumn DelT;

    @FXML Button BackB;
    @FXML Button AddCTCB;

    static Stage stage = new Stage();


    @FXML
     void Back(ActionEvent actionEvent) {
        stage.close();
        new SecretaryUIC().start();
    }


    //
    @FXML
    void AddCTC(ActionEvent actionEvent) {

        Stage AddCTCStage =new Stage();
        try {
            Parent parent=FXMLLoader.load(getClass().getResource("/FXML/AddCTC.fxml"));
            AddCTCStage.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCTCStage.show();


    }




    void showTable(){
        CTCDAO ctcdao=new CTCImpl();
        ObservableList<CTC> list = FXCollections.observableArrayList(ctcdao.findByUnion("all"));
        ClassT.setCellValueFactory(new PropertyValueFactory("ClassName"));
        CourseT.setCellValueFactory(new PropertyValueFactory("CourseName"));
        TeacherT.setCellValueFactory(new PropertyValueFactory("TeachName"));
        BNameT.setCellValueFactory(new PropertyValueFactory("BName"));


        DelT.setCellFactory((col)->{
                    TableCell<Teacher, String> cell = new TableCell<Teacher, String>(){

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
                                //按钮事件自己添加
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
    void initialize(){
        showTable();
    }



    void start(){
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
