package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Rob on 7/18/2017.
 */
public class NewAttractionView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("NewAttractionForm.fxml");
}
