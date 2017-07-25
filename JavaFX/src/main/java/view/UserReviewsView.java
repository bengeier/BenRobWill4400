package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.AttractionAllReviewController;
import main.java.controller.UserReviewsPageController;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.model.Review;

/**
 * Created by Rob on 7/18/2017.
 */
public class UserReviewsView {

    private static String fxml = "UserReviewsPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button back;

    @FXML
    private Label userID;

    @FXML
    private TableView<Review> table;

    @FXML
    private TableColumn<Review, String> nameCol, ratingCol, commentCol, editCol;

    @FXML
    public void initialize() {

        // set up labels
        userID.setText(CurrentState.getEmail() +"'s Reviews");

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        updateTable();
    }

    private void updateTable() {

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("EntityName"));
        ratingCol.setCellValueFactory(
                new PropertyValueFactory<>("rating"));
        commentCol.setCellValueFactory(
                new PropertyValueFactory<>("comment"));
        editCol.setCellValueFactory(
                new PropertyValueFactory<>("edit"));

        table.setItems(UserReviewsPageController.buildData());
        editCol.setCellFactory(UserReviewsPageController.generateCellFactory());
    }
}
