package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MainSM extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Павлов П.О. Программа перетворення регулярної граматики годинника в скінченний автомат.");
        primaryStage.setScene(new Scene(root));
        //primaryStage.setMaximized(true);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
