package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by wepperson on 7/18/17.
 */
public class CategoryView {

    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("CategoryPage.fxml");

    @FXML
    Button addCategory, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(ManagerView.instance);
        }));

        addCategory.setOnAction((event -> {
            RootView.instance.setCenter(ReviewView.instance);
        }));
    }
}
