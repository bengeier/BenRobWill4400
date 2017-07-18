package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/12/17.
 */
public class AttractionView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("AttractionPage.fxml");

    @FXML
    Button reviewThisAttraction, viewAllReviews, back;

    @FXML
    public void initialize() {
        reviewThisAttraction.setOnAction((event -> {
            RootView.instance.setCenter(ReviewView.instance);
        }));

        viewAllReviews.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));

        back.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));
    }
}
