package main.java.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import main.java.controller.LoginController;
import main.java.model.CurrentUser;

/**
 * Created by Rob on 7/6/2017.
 */
public class LoginView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("LoginPage.fxml");

    @FXML
    private Button toSignUp, logIn;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label loginResult;

    @FXML
    public void initialize() {
        toSignUp.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
        }));

        email.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                logIn();
            }
        });
        password.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                logIn();
            }
        });
    }

    @FXML
    private void logIn() {
        loginResult.setText("");
        if (LoginController.login(email.getText(), password.getText()) == 2) {

            CurrentUser.setEmail(email.getText());
            RootView.instance.setCenter(ManagerView.instance);
        } else if (LoginController.login(email.getText(), password.getText()) == 1) {
            CurrentUser.setEmail(email.getText());
            RootView.instance.setCenter(UserView.instance);
        } else {
            loginResult.setText("Incorrect Username/Password.");
        }
        email.clear();
        password.clear();
    }
}
