package cn.nomango.FuckKuwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/layout.fxml"));
        primaryStage.setTitle("Fuck Kuwo");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(550);
        primaryStage.setMinHeight(520);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
