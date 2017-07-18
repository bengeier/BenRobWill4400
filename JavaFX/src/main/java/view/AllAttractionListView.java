package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class AllAttractionListView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("AllAttractionList.fxml");

    @FXML
    Button add, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(UserView.instance);
        }));

        add.setOnAction((event -> {
            RootView.instance.setCenter(NewAttractionView.instance);
        }));
    }
}
