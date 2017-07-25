package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.AttractionAllReviewController;
import main.java.controller.CityAllReviewController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.Review;

/**
 * Created by wepperson on 7/18/17.
 */
public class CityAllReviewView {

    private static String fxml = "CityAllReviewPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button reviewCity, back;

    @FXML
    private Label cityID;

    @FXML
    private TableView<Review> table;

    @FXML
    private TableColumn<Review, String> usernameCol, ratingCol, commentCol;

    @FXML
    public void initialize() {

        // set up labels
        City curCity = CurrentState.getCurrentCity();
        cityID.setText(curCity.getCityName() +"'s Reviews");

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        reviewCity.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(ReviewView.getInstance());
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

        table.setItems(CityAllReviewController.buildData());
    }
}
