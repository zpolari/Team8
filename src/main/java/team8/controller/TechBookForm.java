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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import team8.dao.impl.BooksImpl;
import team8.model.Book;
import team8.model.Secretary;
import team8.model.Teacher;

import java.io.IOException;
import java.util.Optional;

/**
 * 教科书查看窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */



public class TechBookForm {
    static Stage stage = new Stage();
    public Button AddTechbookB;
    public Button BackB;
    static Object whoUpMe;
    public TextField query;
    public TableColumn Edit;
    public TableColumn Del;

    @FXML
    TableView TechBook;
    @FXML
    TableColumn ISBN;
    @FXML
    TableColumn BNAME;
    @FXML
    TableColumn AUTHOR;
    @FXML
    TableColumn TYPE;
    @FXML
    TableColumn PUBLISHER;
    @FXML
    TableColumn PUBLISHTIME;


    public void showList() {
        ObservableList<Book> list = FXCollections.observableArrayList(new BooksImpl().findAll());

        ISBN.setCellValueFactory(new PropertyValueFactory("ISBN"));//映射
        BNAME.setCellValueFactory(new PropertyValueFactory("BName"));//映射
        AUTHOR.setCellValueFactory(new PropertyValueFactory("Author"));//映射
        TYPE.setCellValueFactory(new PropertyValueFactory("Type"));//映射
        PUBLISHER.setCellValueFactory(new PropertyValueFactory("Publisher"));//映射
        PUBLISHTIME.setCellValueFactory(new PropertyValueFactory("PublishTime"));//映射


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
                                Book book = list.get(getIndex());
                                //按钮事件自己添加
                                new AddTechbookC().start(book,whoUpMe);
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
                                Book book = list.get(getIndex());


                                Alert deleteCheck = new Alert(Alert.AlertType.CONFIRMATION);
                                deleteCheck.setTitle("教科书删除确认");
                                deleteCheck.setHeaderText("请确认以下教科书信息后选择是否删除");
                                deleteCheck.setContentText(book.toString());

                                Optional<ButtonType> result = deleteCheck.showAndWait();
                                if (result.get() == ButtonType.OK){
                                    if (new BooksImpl().delBook(book.getISBN())){
                                        Alert infoTell = new Alert(Alert.AlertType.WARNING);
                                        infoTell.setTitle("提示信息");
                                        infoTell.setHeaderText("删除此教科书成功");
                                        infoTell.setContentText("删除成功"+book.toString());
                                        infoTell.showAndWait();
                                    }else {
                                        Alert infoTell = new Alert(Alert.AlertType.WARNING);
                                        infoTell.setTitle("提示信息");
                                        infoTell.setHeaderText("删除此教科书失败");
                                        infoTell.setContentText("原因：此教科书有课程使用，无法删除");
                                        infoTell.showAndWait();
                                    }
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



        TechBook.setItems(list);
    }

    @FXML
    void initialize() {
        showList();
    }

    void start(Object o) {
        stage.setTitle("教科书查看窗");

        whoUpMe = o;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TechBookForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/CSS/textbook.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();
    }


    public void addTechbook(ActionEvent actionEvent) {
        stage.close();
        new AddTechbookC().start(new Book(), whoUpMe);

    }

    public void back(ActionEvent actionEvent) {

        if (whoUpMe instanceof Teacher) {
            stage.close();
            new TeacherUIC().start((Teacher) whoUpMe);
            System.out.println("TECH");
        }
        if (whoUpMe instanceof Secretary) {
            stage.close();
            new SecretaryUIC().start();
            System.out.println("SEC");
        }
    }

    public void queryKP(KeyEvent keyEvent) {
        ObservableList<Book> list = FXCollections.observableArrayList(new BooksImpl().findAll());
        if (query.getText().equals("")) {
            TechBook.setItems(list);
            return;
        }
        ObservableList<Book> tmp = FXCollections.observableArrayList();
        for (Book book : list
        ) {
            if (book.toString().contains(query.getText())) {
                tmp.add(book);
            }
        }

        ISBN.setCellValueFactory(new PropertyValueFactory("ISBN"));//映射
        BNAME.setCellValueFactory(new PropertyValueFactory("BName"));//映射
        AUTHOR.setCellValueFactory(new PropertyValueFactory("Author"));//映射
        TYPE.setCellValueFactory(new PropertyValueFactory("Type"));//映射
        PUBLISHER.setCellValueFactory(new PropertyValueFactory("Publisher"));//映射
        PUBLISHTIME.setCellValueFactory(new PropertyValueFactory("PublishTime"));//映射


        TechBook.setItems(tmp);


    }
}
