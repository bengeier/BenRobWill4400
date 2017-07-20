package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.java.controller.LoginController;

/**
 * Created by Rob on 7/6/2017.
 */
public class LoginView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("LoginPage.fxml");

    @FXML
    private Button toSignUp, logIn;

    @FXML
    private TextField email, password;

    @FXML
    public void initialize() {
        toSignUp.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
        }));

        logIn.setOnAction((event -> {
            if (LoginController.login(email.getText(), password.getText())) {
                RootView.instance.setCenter(UserView.instance);
            }
        }));
    }
}
