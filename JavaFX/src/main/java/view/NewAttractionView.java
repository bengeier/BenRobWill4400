package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by Rob on 7/18/2017.
 */
public class NewAttractionView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("NewAttractionForm.fxml");

    @FXML
    Button submit, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(AllAttractionListView.instance);
        }));
    }
}
