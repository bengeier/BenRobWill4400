package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllAttractionsListViewController;
import main.java.controller.AllCitiesListController;
import main.java.controller.AttractionAllReviewController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.Review;
import main.java.sql.DBConnection;

import java.sql.SQLException;

/**
 * Created by wepperson on 7/18/17.
 */
public class AttractionAllReviewView {

    private static String fxml = "AttractionAllReview.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button reviewAttraction, back;

    @FXML
    private Label attractionNameID;

    @FXML
    private TableView<Review> table;

    @FXML
    private TableColumn<Review, String> usernameCol, ratingCol, commentCol;

    private TableColumn<Review, String> deleteCol = new TableColumn<>("Delete");

    @FXML
    public void initialize() {

        // set up labels
        Attraction curAttraction = CurrentState.getCurrentAttraction();
        attractionNameID.setText(curAttraction.getAttractionName() +"'s Reviews");

        // button action
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        reviewAttraction.setOnAction((event -> {
            if (!CurrentState.isSuspended()) {
                CurrentState.push(fxml);
                RootView.instance.setCenter(ReviewView.getInstance());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Add New Review");
                alert.setHeaderText("Suspended Users Cannot Add New Reviews.");
                alert.setContentText("Please contact a manager if you wish to remove suspension.");
                alert.showAndWait();
            }

        }));

        updateTable();
    }


    private void updateTable() {

        usernameCol.setCellValueFactory(
                new PropertyValueFactory<>("userEmail"));
        ratingCol.setCellValueFactory(
                new PropertyValueFactory<>("rating"));
        commentCol.setCellValueFactory(
                new PropertyValueFactory<>("comment"));

        table.setItems(AttractionAllReviewController.buildData());

        if (CurrentState.isManagerView()) {
            table.getColumns().add(deleteCol);
            deleteCol.setCellValueFactory(
                    new PropertyValueFactory<>("delete"));
            deleteCol.setCellFactory(AttractionAllReviewController.generateCellFactory("delete"));
        }
    }


}
