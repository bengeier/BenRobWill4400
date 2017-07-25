package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import main.java.controller.ReviewViewController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;

import java.util.zip.CRC32;

/**
 * Created by wepperson on 7/18/17.
 */
public class ReviewView {

    private static String fxml = "ReviewPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button submitReview, back, deleteButton;

    @FXML
    private Label title;

    @FXML
    private ComboBox<Integer> rating;

    @FXML
    private TextArea comment;

    @FXML
    public void initialize() {
        title.setText(getTitleText());

        back.setOnAction((event -> RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()))));

        deleteButton.setVisible(CurrentState.peek().equals("UserReviewsPage.fxml"));
        deleteButton.setOnAction(event -> {
                    ReviewViewController.deleteReview(CurrentState.getCurrentReview());
                    RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        });

        submitReview.setOnAction((event -> {
            ReviewViewController.addNewReview(
                    CurrentState.getEmail(),
                    CurrentState.peek().equals("AttractionPage.fxml") ?
                            CurrentState.getCurrentAttraction().getAttractionEID() :
                            CurrentState.getCurrentCity().getCityEID(),
                    rating.getValue().toString(),
                    comment.getText()

            );
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
    private String getTitleText() {
        if (CurrentState.peek().equals("UserReviewsPage.fxml")) {
            return "Edit Review for " + CurrentState.getCurrentReview().getEntityName();
        }
        return CurrentState.peek().equals("AttractionPage.fxml") ? "New Attraction Review For " +
                CurrentState.getCurrentAttraction().getAttractionName() : "New City Review For " +
                CurrentState.getCurrentCity().getCityName();
    }
}
