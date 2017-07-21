package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/12/17.
 */
public class AttractionView {

    private static String fxml = "AttractionPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button reviewThisAttraction, viewAllReviews, back;

    @FXML
    public void initialize() {
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
