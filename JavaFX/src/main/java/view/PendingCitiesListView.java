package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class PendingCitiesListView {

    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("PendingCitiesList.fxml");

    @FXML
    Button back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(ManagerView.instance);
        }));
    }
}
