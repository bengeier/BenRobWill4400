package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import main.java.controller.ReviewViewController;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import org.omg.CORBA.Current;

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

        deleteButton.setVisible(!isNewReview());
        deleteButton.setOnAction(event -> {
                    ReviewViewController.deleteReview(CurrentState.getCurrentReview());
                    RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        });

        submitReview.setOnAction((event -> {
            if (isNewReview()) {
                ReviewViewController.addNewReview(
                        CurrentState.getEmail(),
                        CurrentState.peek().equals("AttractionPage.fxml") ?
                                CurrentState.getCurrentAttraction().getAttractionEID() :
                                CurrentState.getCurrentCity().getCityEID(),
                        rating.getValue().toString(),
                        comment.getText()
                );
            } else {
                String eid;
                if (CurrentState.peek().equals("UserReviewsPage.fxml")) {
                    eid = CurrentState.getCurrentReview().getReviewableEID();
                } else if (CurrentState.peek().equals("AttractionPage.fxml")) {
                    eid = CurrentState.getCurrentAttraction().getAttractionEID();
                } else {
                    eid = CurrentState.getCurrentCity().getCityEID();
                }
                ReviewViewController.updateReview(
                        eid,
                        rating.getValue().toString(),
                        comment.getText()
                );
            }
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }

    private String getTitleText() {
        if (CurrentState.peek().equals("UserReviewsPage.fxml")) {
            return "Edit Review for " + CurrentState.getCurrentReview().getEntityName();
        }
        if (CurrentState.peek().equals("AttractionPage.fxml")) {
            return (ReviewViewController.isNewReview(CurrentState.getCurrentAttraction().getAttractionEID()) ?
                    "New Review For " : "Edit Review For ") + CurrentState.getCurrentAttraction().getAttractionName();
        }
        return (ReviewViewController.isNewReview(CurrentState.getCurrentCity().getCityEID()) ?
                "New Review For " : "Edit Review For ") + CurrentState.getCurrentCity().getCityName();
    }

    private boolean isNewReview() {
        if (CurrentState.peek().equals("UserReviewsPage.fxml")) {
            return false;
        }
        if (CurrentState.peek().equals("AttractionPage.fxml")) {
            return ReviewViewController.isNewReview(CurrentState.getCurrentAttraction().getAttractionEID());
        }
        return ReviewViewController.isNewReview(CurrentState.getCurrentCity().getCityEID());
    }
}
