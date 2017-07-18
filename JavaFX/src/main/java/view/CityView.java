package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class CityView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("CityPage.fxml");

    @FXML
    Button reviewThisCity, viewAllReviews, back;

    @FXML
    public void initialize() {
        reviewThisCity.setOnAction((event -> {
            RootView.instance.setCenter(ReviewView.instance);
        }));

        viewAllReviews.setOnAction((event -> {
            RootView.instance.setCenter(CityAllReviewView.instance);
        }));

        back.setOnAction((event -> {
            RootView.instance.setCenter(AllCitiesView.instance);
        }));
    }
}
