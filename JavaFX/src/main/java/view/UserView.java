package main.java.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.java.controller.UserController;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/6/2017.
 */
public class UserView {

    private static String fxml = "UserPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button logOut, deleteAccount, myReviews, viewAllCities, viewAllAttractions, search;

    @FXML
    private Label welcomeMessage, searchFail;

    @FXML
    private ComboBox<String> cities, categories, sort;

    @FXML
    public void initialize() {
        cities.setItems(UserController.cityNamesList());
        categories.setItems(UserController.categoriesList());

        welcomeMessage.setText("Welcome " + CurrentState.getEmail() + "!");

        search.setOnAction(event -> {
            if (cities.getValue().equals("City")) {
                searchFail.setText("Please select a city");
            }
            //TODO: handle search function
        });

        sort.setItems(FXCollections.observableArrayList("A -> Z", "Z -> A"));
        sort.valueProperty().addListener((observable, oldValue, newValue) -> {
            cities.setItems(UserController.cityNamesList(newValue));
            categories.setItems(UserController.categoriesList(newValue));
        });

        logOut.setOnAction((event -> {
            RootView.instance.setCenter(LoginView.getInstance());
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
            CurrentState.push(fxml);
            RootView.instance.setCenter(AllCitiesView.getInstance());
        }));

        myReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(UserReviewsView.getInstance());
        }));

        viewAllAttractions.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(AllAttractionListView.getInstance());
        }));
    }
}
