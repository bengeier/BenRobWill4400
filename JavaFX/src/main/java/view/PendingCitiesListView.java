package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import main.java.model.PendingCity;
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
    private TableView<PendingCity> pendingCitiesTable;

    @FXML
    private TableColumn<PendingCity, String> cityNameCol, countryCol, submittedByCol,
            ratingCol, commentCol, approveCol, deleteCol;

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
