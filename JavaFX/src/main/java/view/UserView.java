package main.java.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import main.java.controller.UserController;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by Rob on 7/6/2017.
 */
public class UserView {

    private static String fxml = "UserPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button logOut, delete, myReviews, viewAllCities,
            viewAllAttractions, searchBtn;

    @FXML
    private Label welcomeMessage, searchFail;

    @FXML
    private ComboBox<City> cities;

    @FXML
    private ComboBox<String> categories;

    @FXML
    private TextField attractionName;

    @FXML
    public void initialize() {
        cities.setItems(UserController.cityNamesList());
        categories.setItems(UserController.categoriesList());

        welcomeMessage.setText("Welcome " + CurrentState.getEmail() + "!");

        searchBtn.setOnAction(event -> {
            search();
        });


        searchBtn.setOnAction(event -> search());

        logOut.setOnAction((event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Log Out");
            alert.setHeaderText("Click 'OK' to Log Out");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CurrentState.setSuspended(false);
                RootView.instance.setCenter(LoginView.getInstance());
            }
        }));

        delete.setOnAction((event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete Account");
            alert.setHeaderText("Are You Sure?");
            alert.setContentText("Deleting your account will get rid of your "
                + "reviews, pending attractions, and pending cities. This action "
                + "cannot be undone. Do you wish to proceed?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                try {
                    PreparedStatement deleteUser = DBConnection.connection.prepareStatement(
                            "delete from rateacity.user where Email=" + "\'" + CurrentState.getEmail() + "\'");
                    deleteUser.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                RootView.instance.setCenter(LoginView.getInstance());
            }
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

    @FXML
    private void search() {
        searchFail.setText("");
        CurrentState.push(fxml);

        if(attractionName.getText().isEmpty()) {
            // neither specified
            if (cities.getSelectionModel().isEmpty()
                    && categories.getSelectionModel().isEmpty()) {

                CurrentState.setCurrentCategory("");
                CurrentState.setCurrentCity(null);

                RootView.instance.setCenter(AllAttractionListView.getInstance());

                // ONLY category specified
            } else if (cities.getSelectionModel().isEmpty()
                    && !categories.getSelectionModel().isEmpty()) {

                CurrentState.setCurrentCategory(categories.getValue());
                CurrentState.setCurrentCity(null);

                RootView.instance.setCenter(AllAttractionListView.getInstance());

                // ONLY city specified
            } else if (!cities.getSelectionModel().isEmpty()
                    && categories.getSelectionModel().isEmpty()) {

                CurrentState.setCurrentCity(cities.getValue());
                CurrentState.setCurrentCategory("");

                RootView.instance.setCenter(CityView.getInstance());

                // BOTH specified
            } else {
                CurrentState.setCurrentCity(cities.getValue());
                CurrentState.setCurrentCategory(categories.getValue());

                RootView.instance.setCenter(CityView.getInstance());

            }
        } else {
            // search for attraction with specific name


        }


    }
}
