package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by Rob on 7/6/2017.
 */
public class UserView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("UserPage.fxml");

    @FXML
    private Button logOut, deleteAccount, myReviews, viewAllCities, viewAllAttractions;

    @FXML
    public void initialize() {
        logOut.setOnAction((event -> {
            RootView.instance.setCenter(LoginView.instance);
        }));
    }
}
