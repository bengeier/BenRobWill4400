package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.AllCitiesListController;
import main.java.model.City;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/12/2017.
 */
public class AllCitiesView {

    private static String fxml = "AllCitiesList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button addNewCity, backToUser;

    @FXML
    private TableView<City> citiesTable;

    @FXML
    private TableColumn<City, String> cityCol, avgRatingCol, numRatingCol, numAttractionCol;

    @FXML
    public void initialize() {
        updateTable();

        backToUser.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        addNewCity.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(NewCityView.getInstance());
        }));
    }

    private void updateTable() {
        cityCol.setCellValueFactory(
                new PropertyValueFactory<City, String>("city"));
        avgRatingCol.setCellValueFactory(
                new PropertyValueFactory<City, String>("avgRating"));
        numRatingCol.setCellValueFactory(
                new PropertyValueFactory<City, String>("numRatings"));
        numAttractionCol.setCellValueFactory(
                new PropertyValueFactory<City, String>("numAttractions"));

        citiesTable.setItems(AllCitiesListController.buildData());
    }
}
