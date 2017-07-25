package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.java.controller.AttractionController;
import main.java.controller.SearchController;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.util.Optional;

/**
 * Created by wepperson on 7/12/17.
 */
public class AttractionView {

    private static String fxml = "AttractionPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button reviewThisAttraction, viewAllReviews, back;

    @FXML
    private Label attractionNameID, addressLabel, descriptionLabel, averageLabel, hoursLabel, contactLabel, categoryLabel;

    @FXML
    public void initialize() {

        Attraction curAttraction;
        boolean safe = true;

        if (CurrentState.isAttractionSearch()) {

            System.out.println("It's a search!");

            curAttraction = SearchController.search();

            if (curAttraction == null) {

                safe = false;

            } else {

                CurrentState.setCurrentAttraction(curAttraction);

            }

            CurrentState.setIsAttractionSearch(false);

        }

        if (safe) {
            curAttraction = CurrentState.getCurrentAttraction();
            attractionNameID.setText(curAttraction.getAttractionName());
            addressLabel.setText(curAttraction.getAddress());
            descriptionLabel.setText(curAttraction.getDescription());
            averageLabel.setText(curAttraction.getAveRating() + " (based on " +
                    curAttraction.getNumRatings() + " ratings.)");
            hoursLabel.setText(curAttraction.getHours() == null ? "N/A" : curAttraction.getHours());
            contactLabel.setText(curAttraction.getContact() == null ? "N/A" : curAttraction.getContact());
            categoryLabel.setText(curAttraction.getCategory());

            reviewThisAttraction.setText(AttractionController.isNewReview()
                    ? "Review This City" : "Edit Review");
            reviewThisAttraction.setOnAction((event -> {
                if (!CurrentState.isSuspended()) {
                    CurrentState.push(fxml);
                    RootView.instance.setCenter(ReviewView.getInstance());
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cannot Submit Review");
                    alert.setHeaderText("Suspended Users Cannot Submit Reviews.");
                    alert.setContentText("Please contact a manager if you wish to remove suspension.");
                    alert.showAndWait();
                }
            }));

        } else {

            System.out.println("FAILED SEARCH AAAAAAHHHHHH");
            reviewThisAttraction.setDisable(true);
            viewAllReviews.setDisable(true);

            attractionNameID.setText("No Match!");
        }

        viewAllReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(AttractionAllReviewView.getInstance());
        }));

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
}
