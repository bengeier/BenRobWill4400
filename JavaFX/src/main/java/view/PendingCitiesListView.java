package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import main.java.model.City;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class PendingCitiesListView {

    private static String fxml = "PendingCitiesList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private TableView<City> pendingCitiesTable;

    @FXML
    private TableColumn<City, String> cityCol, avgRatingCol, numRatingCol, numAttractionCol, link;

    @FXML
    Button back;

    @FXML
    public void initialize() {
        //updateTable();
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));
    }
}
