package main.java.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.AllAttractionsListViewController;
import main.java.controller.PendingAttractionsListController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.PendingAttraction;

import java.util.Iterator;

/**
 * Created by wepperson on 7/18/17.
 */
public class PendingAttractionsView {

    private static String fxml = "PendingAttractionsPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    Button back;

    @FXML
    private Label categoryLabel;

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
        approveCol.setCellFactory(PendingAttractionsListController.generateCellFactory("approve"));
        approveCol.setSortable(false);
        deleteCol.setCellFactory(PendingAttractionsListController.generateCellFactory("delete"));
        deleteCol.setSortable(false);

        ObservableList<PendingAttraction> forTable = combineCategories(PendingAttractionsListController.buildData());


        //  check here for if matches search category
        if (!CurrentState.getCurrentCategory().equals("") && !CurrentState.getCurrentCategory().equals(null)) {

            categoryLabel.setText("Showing attractions for Category: " + CurrentState.getCurrentCategory());

            Iterator<PendingAttraction> itr = forTable.iterator();
            while (itr.hasNext()) {
                if (!itr.next().getCategoryList().contains(CurrentState.getCurrentCategory())) {
                    itr.remove();
                }
            }
        }

    }

    private ObservableList<PendingAttraction> combineCategories(ObservableList<PendingAttraction> toCombine) {

        ObservableList<PendingAttraction> toReturn = FXCollections.observableArrayList();
        for (PendingAttraction a : toCombine) {
            toReturn.add(a);
        }
        for (int i = 0; i < toReturn.size() - 1; i++) {
            PendingAttraction first = toReturn.get(i);
            PendingAttraction second = toReturn.get(i+1);
            if (first.getAttractionEID().equals(second.getAttractionEID())) {

                for (String s : second.getCategoryList()) {
                    first.addCategory(s);
                }
                toReturn.remove(i+1);
                i--;
            }
        }
        return toReturn;
    }

}
