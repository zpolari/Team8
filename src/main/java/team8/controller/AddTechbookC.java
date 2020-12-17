package team8.controller;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.impl.BookTypeImpl;
import team8.dao.impl.BooksImpl;
import team8.model.Book;
import team8.model.BookType;
import team8.model.Secretary;
import team8.model.Teacher;

import javax.xml.ws.soap.Addressing;
import java.io.IOException;

public class AddTechbookC {

    static Stage stage=new Stage();
    static Book book;
    static String doWhat;
    static Object teacher;

    @FXML
    Label WhoLabel;
    @FXML
    Button BackButton;
    @FXML
    TextField ISBNT;
    @FXML
    TextField BNameT;
    @FXML
    TextField AuthorT;
    @FXML
    TextField PublishT;
    @FXML
    Button AddButton;
    @FXML
    Label MsgLabel;
    @FXML
    ComboBox TypeC;
    @FXML
    TextField PublishTimeT;



    @FXML
    void addTechbook(ActionEvent actionEvent) {

        if (TypeC.getSelectionModel().getSelectedIndex()==-1){
            MsgLabel.setText("请选择类型");
            return;
        }



        Book book=new Book(ISBNT.getText(),BNameT.getText(),AuthorT.getText(),TypeC.getSelectionModel().getSelectedItem().toString(),PublishT.getText(),PublishTimeT.getText());
        System.out.println(book.toString());
        MsgLabel.setText(new BooksImpl().addBook(book));

    }

    @FXML
    void Back(ActionEvent actionEvent) {

        stage.close();
        if (teacher instanceof Teacher){
            new TechBookForm().start(teacher);
            return;
        }

        new TechBookForm().start(new Secretary());


    }

    @FXML
    void initialize(){
        if (book.getISBN()!=null){
            AddButton.setText("保存修改");
            WhoLabel.setText("修改教科书");
        }else {
            WhoLabel.setText("新增教科书");
        }

        ObservableList<String > list = FXCollections.observableArrayList(new BookTypeImpl().findAll());
        TypeC.setItems(list);

    }

    void start(Book b){
        book=b;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/AddTechbook.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();

    }

    void start(Book b,Object t){
        book=b;
        teacher=t;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/AddTechbook.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();

    }
}
