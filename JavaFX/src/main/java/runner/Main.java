package main.java.runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.sql.DBConnection;
import main.java.view.LoginView;
import main.java.view.RootView;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = RootView.instance;
        primaryStage.setTitle("Rate a City");
        primaryStage.setScene(new Scene(root, 800, 600));
        BorderPane loginPane = LoginView.getInstance();
        root.setCenter(loginPane);
        primaryStage.show();

        DBConnection.createConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
