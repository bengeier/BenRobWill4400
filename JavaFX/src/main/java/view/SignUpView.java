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
import main.java.model.CurrentState;

import java.io.IOException;

/**
 * Created by Rob on 7/6/2017.
 */
public class SignUpView {

    private static String fxml = "SignUpPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button backToLogin, signUp;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password1, password2;

    @FXML
    private Label signUpLabel, errorLabel;

    @FXML
    public void initialize() {
        if (CurrentState.isManagerView()) {
            signUpLabel.setText("Add New User");
            signUp.setText("Create");
        }
        backToLogin.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
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
            password1.clear();
            password2.clear();
        } else if (SignUpController.signUp(email.getText(), password2.getText()) == 0) {
            // sign up failed
            errorLabel.setText("Sign up failed! Try another email.");
        } else {

            errorLabel.setText("Success!");
            email.clear();
            password1.clear();
            password2.clear();
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));

        }

    }
}
