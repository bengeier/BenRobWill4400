package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        deleteAccount.setOnAction((event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete Account");
            alert.setHeaderText("Are You Sure?");
            alert.setContentText("Deleting your account will get rid of your "
                + "reviews, pending attractions, and pending cities. This action "
                + "cannot be undone. Do you wish to proceed?");
            alert.showAndWait();
        }));

        viewAllCities.setOnAction((event -> {
            RootView.instance.setCenter(AllCitiesView.instance);
        }));
    }
}
