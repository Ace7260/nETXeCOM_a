package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
   public  static final String CURRENCY="$";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/Store.fxml"));
        primaryStage.setTitle("Ace1 Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(1100);
        primaryStage.setMinHeight(750);
        //primaryStage.setResizable(false);
       // 20:00
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
