package team8.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartFormC {

    @FXML
    Button TeachLoginButton;

    @FXML
    Button SecretaryLoginButton;

    @FXML
    Label TimeLabel;

    static Stage stage = new Stage();


    @FXML
    void TeachLogin(){
        stage.close();
        new LoginFormC().start("教师");

    }

    @FXML
    void SecretaryLogin(){
        stage.close();

        new LoginFormC().start("教学秘书");
    }


    public void start()   {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/StartForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        URL url = getClass().getClassLoader().getResource("ICON/icon.jpg");
//        System.out.println(url.toExternalForm());
//        root.setCursor(Cursor.cursor(url.toExternalForm()));
//
//        ObservableList<BookType> list = FXCollections.observableArrayList();
//        BookType bookTypeInfo=new BookTypeImpl().findAll();
//        bookType.setCellValueFactory(new PropertyValueFactory("bookType1"));
//        list.add(bookTypeInfo);
//        tableView.setItems(list);



        stage.setTitle("Hello World");                                //设置窗口名称
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标
        stage.setScene(new Scene(root));        //设置窗口容器和大小
        stage.setResizable(false);
        stage.show();


    }

}
