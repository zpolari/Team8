package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import team8.dao.impl.BooksImpl;
import team8.model.Book;
import team8.model.Secretary;
import team8.model.Teacher;

import java.io.IOException;

public class TechBookForm {
    static Stage stage = new Stage();
    public Button AddTechbookB;
    public Button BackB;
    static Object whoUpMe;
    public TextField query;

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


        TechBook.setItems(list);
    }

    @FXML
    void initialize() {
        showList();
    }

    void start(Object o) {
        whoUpMe = o;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/TechBookForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
