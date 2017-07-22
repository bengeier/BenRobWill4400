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

        /*
            Unfortunately this code works. You could probably refactor it idk
         */
        link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        Callback<TableColumn<City, String>, TableCell<City, String>> cellFactory
                = new Callback<TableColumn<City, String>, TableCell<City, String>>() {
            @Override
            public TableCell<City, String> call(TableColumn<City, String> param) {
                return new TableCell<City, String>() {
                    final Hyperlink pageLink = new Hyperlink("City Page");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pageLink.setOnAction(event -> {
                                City city = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentCity(city.getCity());
                                RootView.instance.setCenter(CityView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
        link.setCellFactory(cellFactory);
        citiesTable.setItems(AllCitiesListController.buildData());
    }
}
