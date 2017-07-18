package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Created by Rob on 7/6/2017.
 */
public class LoginView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("LoginPage.fxml");

    @FXML
    private Button toSignUp, logIn;

    @FXML
    public void initialize() {
        toSignUp.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
        }));

        logIn.setOnAction((event -> {
            System.out.println("here1");
            RootView.instance.setCenter(UserView.instance);
            System.out.println("here2");

        }));
    }
}
