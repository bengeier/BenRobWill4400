package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.model.City;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/12/2017.
 */
public class AllCitiesView {

    private static String fxml = "AllCitiesList.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button addNewCity, backToUser;

    @FXML
    private TableView<City> citiesTable;

    @FXML
    private TableColumn<City, String> cityCol, avgRatingCol, numRatingCol, numAttractionCol, link;

    @FXML
    public void initialize() {
        updateTable();

        backToUser.setOnAction((event -> RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()))));

        addNewCity.setOnAction((event -> {
            if (!CurrentState.isSuspended()) {
                CurrentState.push(fxml);
                RootView.instance.setCenter(NewCityView.getInstance());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Add New City");
                alert.setHeaderText("Suspended Users Cannot Add New Cities.");
                alert.setContentText("Please contact a manager if you wish to remove suspension.");
                alert.showAndWait();
            }
        }));
    }

    private void updateTable() {
        cityCol.setCellValueFactory(
                new PropertyValueFactory<>("cityName"));
        avgRatingCol.setCellValueFactory(
                new PropertyValueFactory<>("avgRating"));
        numRatingCol.setCellValueFactory(
                new PropertyValueFactory<>("numRatings"));
        numAttractionCol.setCellValueFactory(
                new PropertyValueFactory<>("numAttractions"));
        link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        link.setSortable(false);

        citiesTable.setItems(AllCitiesListController.buildData());

        link.setCellFactory(AllCitiesListController.generateCellFactory());
    }
}
