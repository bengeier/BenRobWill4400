package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/18/2017.
 */
public class UserReviewsView {

    private static String fxml = "UserReviewsPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
}
