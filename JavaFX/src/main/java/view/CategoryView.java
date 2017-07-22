package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import main.java.controller.NewCategoryController;
import main.java.model.CurrentState;

import java.util.Optional;

/**
 * Created by wepperson on 7/18/17.
 */
public class CategoryView {

    private static String fxml = "CategoryPage.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button addCategory, back;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        addCategory.setOnAction((event -> {

            TextInputDialog newCategoryDialog = new TextInputDialog();
            newCategoryDialog.setTitle("New Category");
            newCategoryDialog.setHeaderText("What is the Name of the New Category?");
            newCategoryDialog.setContentText("Please Enter a Name:");

            Optional<String> newCategory = newCategoryDialog.showAndWait();
            addCategory(newCategory.get());
        }));
        
    }
    private void addCategory(String categoryName) {
        NewCategoryController.addCategory(categoryName);
        RootView.instance.setCenter(CategoryView.getInstance());

    }
}
