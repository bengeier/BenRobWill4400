package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by wepperson on 7/18/17.
 */
public class CategoryEditView {

    public static VBox instance = (VBox) FXBuilder.getFXMLView("CategoryEditPage.fxml");

    @FXML
    Button back, submit;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(AllAttractionListView.instance);
        }));

        submit.setOnAction((event -> {
            // TODO
        }));
    }
}
