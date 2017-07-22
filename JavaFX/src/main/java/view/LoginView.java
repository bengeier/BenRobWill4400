package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import main.java.controller.LoginController;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/6/2017.
 */
public class LoginView {

    private static String fxml = "LoginPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

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
        logIn.setOnAction(event -> logIn());

        toSignUp.setOnAction((event -> {
            CurrentState.push(fxml);

            RootView.instance.setCenter(SignUpView.getInstance());
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
            CurrentState.setEmail(email.getText());
            CurrentState.setManagerView(true);
            RootView.instance.setCenter(ManagerView.getInstance());
        } else if (LoginController.login(email.getText(), password.getText()) == 1) {
            CurrentState.setEmail(email.getText());
            RootView.instance.setCenter(UserView.getInstance());

        } else {
            loginResult.setText("Incorrect Username/Password.");
        }
        email.clear();
        password.clear();
    }
}
