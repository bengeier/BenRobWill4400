package main.java.view;

import javafx.scene.layout.BorderPane;

/**
 * Created by Rob on 7/6/2017.
 */
public class RootView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("RootPane.fxml");
}
