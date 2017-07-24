package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.PendingAttractionsListController;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.PendingAttraction;

/**
 * Created by wepperson on 7/18/17.
 */
public class PendingAttractionsView {

    private static String fxml = "PendingAttractionsPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button back;

    @FXML
    private TableView<PendingAttraction> pendingAttractionsTable;

    @FXML
    private TableColumn<PendingAttraction, String> attractionNameCol, cityCol, addressCol, countryCol, categoryCol, descriptionCol,
        hoursCol, contactInfoCol, submittedByCol, ratingCol, commentCol, approveCol, deleteCol;
    @FXML
    public void initialize() {
        updateTable();
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }

    private void updateTable() {
        attractionNameCol.setCellValueFactory(
                new PropertyValueFactory<>("attractionName"));
        cityCol.setCellValueFactory(
                new PropertyValueFactory<>("city"));
        addressCol.setCellValueFactory(
                new PropertyValueFactory<>("address"));
        countryCol.setCellValueFactory(
                new PropertyValueFactory<>("country"));
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        descriptionCol.setCellValueFactory(
                new PropertyValueFactory<>("description"));
        hoursCol.setCellValueFactory(
                new PropertyValueFactory<>("hours"));
        contactInfoCol.setCellValueFactory(
                new PropertyValueFactory<>("contactInfo"));
        submittedByCol.setCellValueFactory(
                new PropertyValueFactory<>("submittedBy"));
        ratingCol.setCellValueFactory(
                new PropertyValueFactory<>("rating"));
        commentCol.setCellValueFactory(
                new PropertyValueFactory<>("comment"));

        pendingAttractionsTable.setItems(PendingAttractionsListController.buildData());
        /*approveCol.setCellValueFactory(
                new PropertyValueFactory<>("some magical approve stuff"));
        deleteCol.setCellValueFactory(
                new PropertyValueFactory<>("some magical delete stuff"));*/
    }
}
