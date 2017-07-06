package main.java.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Created by Rob on 7/6/2017.
 */
public class SignUpView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("SignUpPage.fxml");

    @FXML
    Button backToLogin, signUp;

    @FXML
    public void initialize() {
        backToLogin.setOnAction((event -> {
            RootView.instance.setCenter(LoginView.instance);
        }));

        signUp.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));
    }
}
