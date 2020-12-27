package team8.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.impl.BookTypeImpl;
import team8.dao.impl.BooksImpl;
import team8.model.Book;
import team8.model.Secretary;
import team8.model.Teacher;


import java.io.IOException;
import java.time.LocalDate;

/**
 * 新增/修改 教科书窗口 控制器
 * FXML 节点：WhoLabel、BackButton、ISBNT、BNameT、AuthorT、PublishT、AddButton、MsgLabel、TypeC
 * FXML Func:Back、addTechbook
 * Author:zPolari
 * Time:2020-12-18
 */

public class AddTechbookC {

    static Stage stage = new Stage();
    static Book book;
    static String doWhat;
    static Object teacher;
    public DatePicker dateC;

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
    void addTechbook(ActionEvent actionEvent) {

        if (TypeC.getSelectionModel().getSelectedIndex() == -1) {
            MsgLabel.setText("请选择类型");
            return;
        }
        Book book = new Book(ISBNT.getText(), BNameT.getText(), AuthorT.getText(), TypeC.getSelectionModel().getSelectedItem().toString(), PublishT.getText(), dateC.getValue().toString());

        if (doWhat.equals("UPDATE")) {
            MsgLabel.setText(new BooksImpl().updateBook(book));
        } else {
            MsgLabel.setText(new BooksImpl().addBook(book));
        }

    }


    @FXML
    void Back() {

        stage.close();
        if (teacher instanceof Teacher) {
            new TechBookForm().start(teacher);
            return;
        }
        new TechBookForm().start(new Secretary());

    }

    @FXML
    void initialize() {
        if (book.getISBN() != null) {
            AddButton.setText("保存修改");
            WhoLabel.setText("修改教科书");

            ISBNT.setText(book.getISBN());
            ISBNT.setEditable(false);
            BNameT.setText(book.getBName());
            TypeC.getSelectionModel().select(book.getType());
            AuthorT.setText(book.getAuthor());
            PublishT.setText(book.getPublisher());
            String[] strings = book.getPublishTime().split("-");
            dateC.setValue(LocalDate.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])));

            doWhat = "UPDATE";

        } else {
            WhoLabel.setText("新增教科书");
            doWhat = "ADD";
        }

        ObservableList<String> list = FXCollections.observableArrayList(new BookTypeImpl().findAll());
        TypeC.setItems(list);

    }

    void start(Book b, Object t) {
        book = b;
        teacher = t;
        Parent root = null;
        stage.setTitle("教科书管理");

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
