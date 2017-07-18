package main.java.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Created by Rob on 7/6/2017.
 */
public class FXBuilder {

    /**
     * Loads the .fxml file specified by fxmlName in main.resources.view
     * @param fxmlName the file name of the .fxml file desired
     * @return FXML Node if file is found, null if not
     */
    public static Node getFXMLView(String fxmlName) {
        try {

            return FXMLLoader.load(FXBuilder.class.getResource("../../resources/view/" + fxmlName));
        } catch (IOException e) {
            System.out.println(fxmlName);
            System.out.println(e.getMessage());
        }
        return null;
    }
}
