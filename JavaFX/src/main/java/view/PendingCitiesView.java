package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.controller.PendingCitiesListController;
import main.java.model.City;
import main.java.model.PendingCity;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class PendingCitiesView {

    private static String fxml = "PendingCitiesList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private TableView<PendingCity> pendingCitiesTable;

    @FXML
    private TableColumn<PendingCity, String> cityNameCol, countryCol, submittedByCol,
            ratingCol, commentCol, approveCol, deleteCol;

    @FXML
    Button back;

    @FXML
    public void initialize() {
        System.out.println("intialize pending cities view");
        updateTable();
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
    private void updateTable() {
        cityNameCol.setCellValueFactory(
                new PropertyValueFactory<>("cityName"));
        countryCol.setCellValueFactory(
                new PropertyValueFactory<>("country"));
        submittedByCol.setCellValueFactory(
                new PropertyValueFactory<>("submittedBy"));
        ratingCol.setCellValueFactory(
                new PropertyValueFactory<>("rating"));
        commentCol.setCellValueFactory(
                new PropertyValueFactory<>("comment"));
        approveCol.setCellValueFactory(
                new PropertyValueFactory<>("approve"));
        deleteCol.setCellValueFactory(
                new PropertyValueFactory<>("delete"));
        System.out.println("updating table");
        /*
            Unfortunately this code works. You could probably refactor it idk
         */
        /*link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
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
                                CurrentState.setCurrentCity(city);
                                CurrentState.push(fxml);
                                RootView.instance.setCenter(CityView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
        //link.setCellFactory(cellFactory);*/
        pendingCitiesTable.setItems(PendingCitiesListController.buildData());
    }
}
