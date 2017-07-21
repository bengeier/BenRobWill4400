package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

import java.util.Optional;

/**
 * Created by Rob on 7/18/2017.
 */
public class ManagerView {
    // TODO: update other views to have private instance

    private static String fxml = "ManagerPage.fxml";
    private static BorderPane instance = (BorderPane) FXBuilder.getFXMLView(fxml);

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button logOut, viewAllCities, viewAllAttractions, viewAllCategories, viewAllUsers, viewPendingCities,
        viewPendingAttractions, addNewCity, addNewUser, addNewAttraction, addNewCategory;

    @FXML
    private Label welcomeMessage;

    @FXML
    public void initialize() {
        welcomeMessage.setText("Welcome " + CurrentState.getEmail() + "!");

        logOut.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(LoginView.getInstance());

         }));

        viewAllCities.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(AllCitiesView.getInstance());

        }));

        viewAllAttractions.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(AllAttractionListView.getInstance());

        }));

        viewAllCategories.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(CategoryView.getInstance());

        }));

        viewAllUsers.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(AllUsersListView.getInstance());

        }));

        viewPendingCities.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(PendingCitiesListView.getInstance());

        }));

        viewPendingAttractions.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(PendingAttractionsView.getInstance());

        }));

        addNewCity.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(NewCityView.getInstance());

        }));

        addNewAttraction.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(NewAttractionView.getInstance());

        }));

        addNewUser.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(SignUpView.getInstance());

        }));


        addNewCategory.setOnAction((event -> {
            TextInputDialog newCategoryDialog = new TextInputDialog();
            newCategoryDialog.setTitle("New Category");
            newCategoryDialog.setHeaderText("What is the Name of the New Category?");
            newCategoryDialog.setContentText("Please Enter a Name:");

            Optional<String> newCategory = newCategoryDialog.showAndWait();
            //TODO: add newCategory to database
        }));
    }
}
