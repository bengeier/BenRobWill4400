package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.java.controller.NewAttractionController;
import main.java.model.City;
import main.java.model.CurrentState;

/**
 * Created by Rob on 7/18/2017.
 */
public class NewAttractionView {

    private static String fxml = "NewAttractionForm.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button submit, back;

    @FXML
    private TextField nameField, addressField, descriptionField, hoursField, contactField, commentField;

    @FXML
    private Slider ratingSlider;

    @FXML
    private ComboBox<City> cities;

    @FXML
    private ComboBox<String> categories;

    @FXML
    public void initialize() {
        cities.setItems(NewAttractionController.getCities());
        categories.setItems(NewAttractionController.getCategories());

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        submit.setOnAction((event -> {
            NewAttractionController.addNewAttraction(
                    nameField.getText(),
                    addressField.getText(),
                    descriptionField.getText(),
                    hoursField.getText(),
                    contactField.getText(),
                    commentField.getText(),
                    cities.getValue(),
                    categories.getPromptText(),
                    ((Double)ratingSlider.getValue()).toString()
            );
            RootView.instance.setCenter(AttractionView.getInstance());
        }));
    }
}
