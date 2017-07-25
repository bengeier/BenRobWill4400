package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.java.controller.NewCityController;
import main.java.model.CurrentState;

import javax.xml.soap.Text;

/**
 * Created by Michael Xiao Local on 7/12/2017.
 */

public class NewCityView{

    private static String fxml = "NewCityForm.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button back, submit;

    @FXML
    private TextField nameField, countryField, stateField, commentField;

    @FXML
    private Slider ratingSlider;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        if (CurrentState.isManagerView()) {
            submit.setText("Submit");
        }
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        submit.setOnAction((event -> {
            errorLabel.setText("");
            if (NewCityController.addNewCity(
                    nameField.getText(),
                    countryField.getText(),
                    stateField.getText(),
                    ((Double) ratingSlider.getValue()).toString(),
                    commentField.getText())) {
                RootView.instance.setCenter(CityView.getInstance());
            }
            errorLabel.setText("Please fill in required fields.");
        }));
    }
}
