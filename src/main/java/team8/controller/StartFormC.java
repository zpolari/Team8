package team8.controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 启动窗口 控制器
 * Author:zPolari
 * Time:2020-12-20
 */


public class StartFormC {

    static boolean GlobalSetResizable = true;
    @FXML
    Label lblTitle;
    @FXML
    Button TeachLoginButton;

    @FXML
    Button SecretaryLoginButton;

    @FXML
    Label TimeLabel;

    static Stage stage = new Stage();


    @FXML
    void TeachLogin() {
        stage.close();
        new LoginFormC().start("教师");

    }

    @FXML
    void SecretaryLogin() {
        stage.close();

        new LoginFormC().start("教学秘书");
    }


    /**
     * 方法作用：给主界面上的TimeLabel 实时更新当前时间
     * Author:zPolari
     * Time:2020-12-27
     */
    @FXML
    public void initialize() {
        //新建一个时间格式件器
        DateFormat df = new SimpleDateFormat("当前时间：yyyy年MM月dd日 hh:mm:ss");
        //新建一个关键帧动画
        //关键帧间隔500毫秒，事务：更新TimeLabel的Text为当前时间
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), e -> {
            TimeLabel.setText(df.format(new Date()));
        }));
        //设置循环次数 INDEFINITE为-1  即无限更新
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                TeachLoginButton.setLayoutX(newValue.intValue()*0.2083);
                SecretaryLoginButton.setLayoutX(newValue.intValue()*0.6466);
                TimeLabel.setLayoutX(newValue.intValue()*0.5016);
                lblTitle.setLayoutX(newValue.intValue()*0.167);

                TeachLoginButton.setMinWidth(64*(newValue.doubleValue()/600));
                SecretaryLoginButton.setMinWidth(64*(newValue.doubleValue()/600));
                TimeLabel.setMinWidth(401*(newValue.doubleValue()/600));
            }
        });

        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                TeachLoginButton.setLayoutY(newValue.intValue()*0.4725);
                SecretaryLoginButton.setLayoutY(newValue.intValue()*0.4725);
                TimeLabel.setLayoutY(newValue.intValue()*0.6825);
                lblTitle.setLayoutY(newValue.intValue()*0.175);
                TeachLoginButton.setMinHeight(23*(newValue.doubleValue()/400));
                SecretaryLoginButton.setMinHeight(23*(newValue.doubleValue()/400));
                TimeLabel.setMinHeight(61*(newValue.doubleValue()/400));
            }
        });


    }

    public void start() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/StartForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.getStylesheets().add(getClass().getResource("/CSS/startForm.css").toExternalForm());

        stage.setTitle("人员登录选择窗");                                //设置窗口名称
        stage.getIcons().add(new Image("/ICON/icon.jpg"));        //设置左上角图标
        stage.setScene(new Scene(root));        //设置窗口容器和大小
        stage.setResizable(GlobalSetResizable);
        stage.show();

    }

}
