package team8;

import javafx.application.Application;
import javafx.stage.Stage;
import team8.controller.StartFormC;


/*
创建主类的时候继承javafx.application.Application 来通过
重写start方法来
 */
public class  Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("/FXML/StartForm.fxml"));

//        URL url = getClass().getClassLoader().getResource("ICON/icon.jpg");
//        System.out.println(url.toExternalForm());
//        root.setCursor(Cursor.cursor(url.toExternalForm()));
//
//        ObservableList<BookType> list = FXCollections.observableArrayList();
//        BookType bookTypeInfo=new BookTypeImpl().findAll();
//        bookType.setCellValueFactory(new PropertyValueFactory("bookType1"));
//        list.add(bookTypeInfo);
//        tableView.setItems(list);



//        primaryStage.setTitle("Hello World");                                //设置窗口名称
//        primaryStage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标
//        primaryStage.setScene(new Scene(root));        //设置窗口容器和大小
//        primaryStage.show();

        new StartFormC().start();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
