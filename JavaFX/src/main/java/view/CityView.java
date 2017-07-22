package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class CityView {

    private static String fxml = "CityPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button reviewThisCity, viewAllReviews, back;

    @FXML
    private Label cityName, cityAndCategory;

    @FXML
    public void initialize() {
        cityName.setText(CurrentState.getCurrentCity().getCityName());
        cityAndCategory.setText(CurrentState.getCurrentCategory()
                + " Attractions in " + CurrentState.getCurrentCity());

        reviewThisCity.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(ReviewView.getInstance());
        }));

        viewAllReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(CityAllReviewView.getInstance());
        }));

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
}
