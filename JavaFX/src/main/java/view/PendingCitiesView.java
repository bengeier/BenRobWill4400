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

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
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

        pendingCitiesTable.setItems(PendingCitiesListController.buildData());
        approveCol.setCellFactory(PendingCitiesListController.generateCellFactory("approve"));
        deleteCol.setCellFactory(PendingCitiesListController.generateCellFactory("delete"));
    }
}
