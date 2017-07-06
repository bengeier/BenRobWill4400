package main.java.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Created by Rob on 7/6/2017.
 */
public class FXBuilder {

    public static Node getFXMLView(String fxmlName) {
        try {
            return FXMLLoader.load(FXBuilder.class.getResource("../../resources/view/" + fxmlName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
