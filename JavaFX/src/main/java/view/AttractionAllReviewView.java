package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.controller.AttractionAllReviewController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.Review;

/**
 * Created by wepperson on 7/18/17.
 */
public class AttractionAllReviewView {

    private static String fxml = "AttractionAllReview.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button reviewAttraction, back;

    @FXML
    private Label attractionNameID;

    @FXML
    private TableView<Review> table;

    @FXML
    private TableColumn<Review, String> usernameCol, ratingCol, commentCol;

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

        table.setItems(AttractionAllReviewController.buildData());
    }
}
