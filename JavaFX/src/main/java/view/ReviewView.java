package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import main.java.controller.ReviewViewController;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class ReviewView {

    private static String fxml = "ReviewPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button submitReview, back;

    @FXML
    Label title;

    @FXML
    ComboBox<Integer> rating;

    @FXML
    TextArea comment;

    @FXML
    public void initialize() {
        title.setText(CurrentState.peek().equals("AttractionPage.fxml") ? "New Attraction Review For " +
                CurrentState.getCurrentAttraction().getAttractionName() : "New City Review For " +
                CurrentState.getCurrentCity().getCityName());

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

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

}
