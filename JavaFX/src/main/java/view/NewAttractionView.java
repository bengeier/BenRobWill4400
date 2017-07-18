package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Rob on 7/18/2017.
 */
public class NewAttractionView {
    public static VBox instance = (VBox) FXBuilder.getFXMLView("NewAttractionForm.fxml");

    @FXML
    Button back, submit;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(AllAttractionListView.instance);
        }));


    }
}
