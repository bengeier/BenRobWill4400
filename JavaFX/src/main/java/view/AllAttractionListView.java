package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.AllAttractionsListViewController;
import main.java.controller.AllCitiesListController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class AllAttractionListView {

    private static String fxml = "AllAttractionList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button add, back;

    @FXML
    private TableView<Attraction> attractionsTable;

    @FXML
    private TableColumn<Attraction, String> nameCol, categoryCol, locationCol, avgCol, numCol;

    @FXML
    public void initialize() {
        updateTable();

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        add.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(NewAttractionView.getInstance());
        }));
    }

    private void updateTable() {
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("attraction"));
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        locationCol.setCellValueFactory(
                new PropertyValueFactory<>("city"));
        avgCol.setCellValueFactory(
                new PropertyValueFactory<>("aveRating"));
        numCol.setCellValueFactory(
                new PropertyValueFactory<>("numRatings"));


        attractionsTable.setItems(AllAttractionsListViewController.buildData());
    }
}
