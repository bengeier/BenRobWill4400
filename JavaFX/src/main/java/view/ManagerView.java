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
import org.omg.CORBA.Current;
import sun.util.resources.cldr.ta.CurrencyNames_ta;

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
        viewPendingAttractions, addNewCity, addNewUser, addNewAttraction, addNewCategory, search, searchUsers, myReviews;

    @FXML
    private Label welcomeMessage;

    @FXML
    private ComboBox<City> cities;

    @FXML
    private ComboBox<String> categories;

    @FXML
    private TextField attractionName, userParam;

    @FXML
    public void initialize() {
        cities.setItems(ManagerController.cityNamesList());
        categories.setItems(ManagerController.categoriesList());

        welcomeMessage.setText("Welcome " + CurrentState.getEmail() + "!");

        search.setOnAction(event -> {
            search();
        });

        searchUsers.setOnAction(event -> {
            searchU();
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
            CurrentState.setAttractionSearchParam("");
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

        myReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(UserReviewsView.getInstance());
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
    private void addCategory(String categoryName) {
        NewCategoryController.addCategory(categoryName);
        CurrentState.push(fxml);
        RootView.instance.setCenter(CategoryView.getInstance());

    }

    @FXML
    private void search() {
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

            if(!cities.getSelectionModel().isEmpty()) {
                CurrentState.setCurrentCity(cities.getValue());
            }
            if(!categories.getSelectionModel().isEmpty()) {
                CurrentState.setCurrentCategory(categories.getValue());
            }

            CurrentState.setIsAttractionSearch(true);
            CurrentState.setAttractionSearchParam(attractionName.getText());

            RootView.instance.setCenter(AttractionView.getInstance());

        }
    }

    private void searchU() {
        if (!userParam.getText().equals("")) {
            CurrentState.push(fxml);
            CurrentState.setAttractionSearchParam(userParam.getText());
            RootView.instance.setCenter(AllUsersListView.getInstance());
        }
    }

}
