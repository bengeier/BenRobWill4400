package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class ReviewView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("ReviewPage.fxml");

    @FXML
    Button submitReview, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));
    }

}
