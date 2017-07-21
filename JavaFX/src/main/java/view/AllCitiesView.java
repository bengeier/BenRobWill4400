package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

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
            CurrentState.push(this.instance);
            RootView.instance.setCenter(CurrentState.pop());
        }));

        addNewCity.setOnAction((event -> {
            RootView.instance.setCenter(NewCityView.instance);
        }));
    }
}
