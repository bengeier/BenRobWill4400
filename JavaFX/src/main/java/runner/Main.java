package main.java.runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.sql.DBConnection;
import main.java.view.LoginView;
import main.java.view.RootView;

/**
 * Created by Rob on 7/3/2017.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Creates new stage with RootView as the base pane
        BorderPane root = RootView.instance;
        primaryStage.setTitle("Rate a City");
        primaryStage.setScene(new Scene(root, 800, 600));

        // Sets the center of RootView to be an instance of LoginView
        BorderPane loginPane = LoginView.instance;
        root.setCenter(loginPane);

        primaryStage.show();

        // Establishes database connection. Reference this by using DBConnection.connection
        DBConnection.createConnection();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
