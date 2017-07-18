package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Rob on 7/18/2017.
 */
public class ManagerView {
    public static VBox instance = (VBox) FXBuilder.getFXMLView("ManagerPage.fxml");

    @FXML
    Button logOut;

    @FXML
    public void initialize() {
        logOut.setOnAction((event -> {
            RootView.instance.setCenter(LoginView.instance);
        }));
    }
}
