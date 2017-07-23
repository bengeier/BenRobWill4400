package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;

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
        Attraction curAttraction = CurrentState.getCurrentAttraction();
        attractionNameID.setText(curAttraction.getAttractionName());
        addressLabel.setText(curAttraction.getAddress());
        descriptionLabel.setText(curAttraction.getDescription());
        averageLabel.setText(curAttraction.getAveRating() + " (based on " +
            curAttraction.getNumRatings() + " ratings.)");
        hoursLabel.setText(curAttraction.getHours() == null ? "N/A" : curAttraction.getHours());
        contactLabel.setText(curAttraction.getContact() == null ? "N/A" : curAttraction.getContact());
        categoryLabel.setText(curAttraction.getCategory());

        reviewThisAttraction.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(ReviewView.getInstance());
        }));

        viewAllReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(UserView.getInstance());
        }));

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
}
