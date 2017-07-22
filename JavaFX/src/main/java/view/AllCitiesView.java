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
    private TableColumn<City, String> cityCol, avgRatingCol, numRatingCol, numAttractionCol, link;

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
                new PropertyValueFactory<>("city"));
        avgRatingCol.setCellValueFactory(
                new PropertyValueFactory<>("avgRating"));
        numRatingCol.setCellValueFactory(
                new PropertyValueFactory<>("numRatings"));
        numAttractionCol.setCellValueFactory(
                new PropertyValueFactory<>("numAttractions"));
        link.setCellValueFactory(
                new PropertyValueFactory<>("link"));

        citiesTable.setItems(AllCitiesListController.buildData());
    }
}
