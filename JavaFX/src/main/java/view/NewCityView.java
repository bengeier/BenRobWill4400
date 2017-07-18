package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by Michael Xiao Local on 7/12/2017.
 */

public class NewCityView{
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("NewCityForm.fxml");


    //@FXML
    //public void initialize() {
        /*toSignUp.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
        }));

        logIn.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));*/
    //}
}
