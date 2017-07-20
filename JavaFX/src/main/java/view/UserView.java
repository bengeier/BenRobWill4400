package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentUser;

/**
 * Created by Rob on 7/6/2017.
 */
public class UserView {
    // TODO: update other views to have private instance
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("UserPage.fxml");

    public BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView("UserPage.fxml");
        return instance;
    }


    @FXML
    private Button logOut, deleteAccount, myReviews, viewAllCities, viewAllAttractions;

    @FXML
    private Label welcomeMessage;

    @FXML
    public void initialize() {
        welcomeMessage.setText(CurrentUser.getEmail());

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

        myReviews.setOnAction((event -> {
            RootView.instance.setCenter(UserReviewsView.instance);
        }));

        viewAllAttractions.setOnAction((event -> {
            RootView.instance.setCenter(AllAttractionListView.instance);
        }));
    }
}
