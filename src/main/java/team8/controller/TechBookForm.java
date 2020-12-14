package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.model.Books;

import java.io.IOException;

public class TechBookForm {
    static Stage stage = new Stage();

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


    public void showList(){
        ObservableList<Books.Book> list = FXCollections.observableArrayList(Books.getInstance().getArr());

        ISBN.setCellValueFactory(new PropertyValueFactory("ISBN"));//映射
        BNAME.setCellValueFactory(new PropertyValueFactory("BName"));//映射
        AUTHOR.setCellValueFactory(new PropertyValueFactory("Author"));//映射
        TYPE.setCellValueFactory(new PropertyValueFactory("Type"));//映射
        PUBLISHER.setCellValueFactory(new PropertyValueFactory("Publisher"));//映射
        PUBLISHTIME.setCellValueFactory(new PropertyValueFactory("PublishTime"));//映射


        TechBook.setItems(list);
    }

    @FXML
    void initialize(){
        showList();
    }

    void start(){
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



}
