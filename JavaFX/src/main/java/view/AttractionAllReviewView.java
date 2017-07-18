package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class AttractionAllReviewView {

    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("AttractionAllReview.fxml");

    @FXML
    Button reviewAttraction, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(AttractionView.instance);
        }));

        reviewAttraction.setOnAction((event -> {
            RootView.instance.setCenter(ReviewView.instance);
        }));
    }
}
