package main.java.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import main.java.controller.ManagerController;
import main.java.controller.NewCategoryController;
import main.java.controller.UserController;
import main.java.model.City;
import main.java.model.CurrentState;

import java.util.Optional;

public class ManagerView {
    // TODO: update other views to have private instance

    private static String fxml = "ManagerPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button logOut, viewAllCities, viewAllAttractions, viewAllCategories, viewAllUsers, viewPendingCities,
        viewPendingAttractions, addNewCity, addNewUser, addNewAttraction, addNewCategory, search, searchAllAttractions;

    @FXML
    private Label welcomeMessage, searchFail;

    @FXML
    private ComboBox<City> cities;

    @FXML
    private ComboBox<String> categories, sort;

    @FXML
    public void initialize() {
        cities.setItems(ManagerController.cityNamesList(""));
        categories.setItems(ManagerController.categoriesList(""));

        welcomeMessage.setText("Welcome " + CurrentState.getEmail() + "!");

        search.setOnAction(event -> {
            search();
        });

        sort.setItems(FXCollections.observableArrayList("A -> Z", "Z -> A"));
        sort.valueProperty().addListener((observable, oldValue, newValue) -> {
            cities.setItems(ManagerController.cityNamesList(newValue));
            categories.setItems(ManagerController.categoriesList(newValue));
        });

        logOut.setOnAction((event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Log Out");
            alert.setHeaderText("Click 'OK' to Log Out");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CurrentState.setManagerView(false);
                RootView.instance.setCenter(LoginView.getInstance());
            }
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
            RootView.instance.setCenter(PendingCitiesView.getInstance());

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
            if (newCategory.isPresent()) {
                addCategory(newCategory.get());
            }
        }));
    }

    @FXML
    private void search() {
        searchFail.setText("");
        if (cities.getSelectionModel().isEmpty()) {
            searchFail.setText("Please select a city");
        }
        CurrentState.setCurrentCity(cities.getValue());
        if (!categories.getSelectionModel().isEmpty()) {
            CurrentState.setCurrentCategory(categories.getValue());
        }
        CurrentState.push(fxml);
        RootView.instance.setCenter(CityView.getInstance());
    }
    @FXML
    private void addCategory(String categoryName) {
        NewCategoryController.addCategory(categoryName);
        CurrentState.push(fxml);
        RootView.instance.setCenter(CategoryView.getInstance());

    }

}
