package main.java.view;

import javafx.scene.layout.VBox;

/**
 * Created by Rob on 7/18/2017.
 */
public class ManagerView {
    public static VBox instance = (VBox) FXBuilder.getFXMLView("ManagerPage.fxml");
}
