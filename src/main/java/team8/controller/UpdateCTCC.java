package team8.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import team8.dao.BooksDao;
import team8.dao.impl.BooksImpl;
import team8.dao.impl.CTCImpl;
import team8.model.Books;
import team8.model.CTC;
import team8.model.Course;
import team8.model.Teacher;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateCTCC {

    static Stage stage = new Stage();
    static CTC ctc;
    static Teacher teacher;
    static ArrayList<Books.Book> books = new BooksImpl().findAll().getArr();;
    @FXML Label MsgLabel;

    @FXML
    Button BackB;
    @FXML
    Label ClassL;
    @FXML
    Label CourseL;
    @FXML
    ComboBox BNameC;
    @FXML
    ComboBox ISBNC;
    @FXML
    Button SaveB;

    @FXML
    void back(ActionEvent actionEvent) {
        new TeacherCTCC().start(teacher);
        stage.close();
    }

    @FXML
    void save(ActionEvent actionEvent) {

        ctc.setISBN(ISBNC.getSelectionModel().getSelectedItem().toString());
        MsgLabel.setText(new CTCImpl().updateCTC(ctc,ctc));


    }

    void setISBN() {

        ObservableList<String> isbn = FXCollections.observableArrayList();

        for (Books.Book book : books
        ) {
            isbn.add(book.getISBN());
        }
        ISBNC.setItems(isbn);

        ISBNC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                BNameC.getSelectionModel().clearAndSelect(ISBNC.getSelectionModel().getSelectedIndex());
            }
        });
    }

    void setBName() {

        ObservableList<String> bName = FXCollections.observableArrayList();

        for (Books.Book book : books
        ) {
            bName.add(book.getBName());
        }
        BNameC.setItems(bName);

        BNameC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ISBNC.getSelectionModel().clearAndSelect(BNameC.getSelectionModel().getSelectedIndex());
            }
        });
    }

    @FXML
    void initialize() {
        CourseL.setText(ctc.getCourseName());
        ClassL.setText(ctc.getClassName());
        setISBN();
        setBName();

    }


    void start(CTC c, Teacher t) {
        ctc = c;
        teacher = t;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/UpdateCTC.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标

        stage.setResizable(false);
        stage.show();

    }


}
