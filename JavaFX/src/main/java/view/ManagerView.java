package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

import java.util.Optional;

/**
 * Created by Rob on 7/18/2017.
 */
public class ManagerView {
    public static VBox instance = (VBox) FXBuilder.getFXMLView("ManagerPage.fxml");

    @FXML
    private Button logOut, viewAllCities, viewAllAttractions, viewAllCategories, viewAllUsers, viewPendingCities,
        viewPendingAttractions, addNewCity, addNewUser, addNewAttraction, addNewCategory;

    @FXML
    public void initialize() {
        logOut.setOnAction((event -> RootView.instance.setCenter(LoginView.instance)));

        viewAllCities.setOnAction((event -> RootView.instance.setCenter(AllCitiesView.instance)));

        viewAllAttractions.setOnAction(event -> RootView.instance.setCenter(AllAttractionListView.instance));

        viewAllCategories.setOnAction(event -> RootView.instance.setCenter(CategoryView.instance));

        viewAllUsers.setOnAction(event -> RootView.instance.setCenter(AllUsersListView.instance));

        viewPendingCities.setOnAction(event -> RootView.instance.setCenter(PendingCitiesListView.instance));

        viewPendingAttractions.setOnAction(event -> RootView.instance.setCenter(PendingAttractionsView.instance));

        addNewCity.setOnAction((event -> RootView.instance.setCenter(NewCityView.instance)));

        addNewAttraction.setOnAction((event -> RootView.instance.setCenter(NewAttractionView.instance)));

        addNewUser.setOnAction((event -> RootView.instance.setCenter(SignUpView.instance)));

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
