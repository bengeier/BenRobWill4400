package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by Rob on 7/12/2017.
 */
public class AllCitiesView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("AllCitiesList.fxml");

    @FXML
    Button addNewCity, backToUser;

    @FXML
    public void initialize() {
        backToUser.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));
    }
}
