package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
    private Label attractionNameID, descriptionID, averageRatingID, hoursOfOperationID, contactInfoID, categoryID;

    @FXML
    public void initialize() {
        attractionNameID.setText(CurrentState.getCurrentAttraction().getAttractionName());

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
