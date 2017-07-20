package main.java.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import main.java.controller.LoginController;
import main.java.controller.SignUpController;

import java.io.IOException;

/**
 * Created by Rob on 7/6/2017.
 */
public class SignUpView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("SignUpPage.fxml");

    @FXML
    Button backToLogin, signUp;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password1, password2;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        backToLogin.setOnAction((event -> {
            RootView.instance.setCenter(LoginView.instance);
        }));

        signUp.setOnAction((event -> {
            signUp();
        }));

        email.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                signUp();
            }
        });
        password1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                signUp();
            }
        });
        password2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                signUp();
            }
        });
    }

    @FXML
    private void signUp() {

        if (!password1.getText().equals(password2.getText())) {
            // passwords dont match
            errorLabel.setText("Passwords must match!");
        }

        if (SignUpController.signUp(email.getText(), password2.getText()) == 0) {
            // sign up failed
            errorLabel.setText("Sign up failed!");
        } else {
            errorLabel.setText("Success!");
            RootView.instance.setCenter(LoginView.instance);

        }
        email.clear();
        password1.clear();
        password2.clear();
    }
}
