package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.CategoriesListController;
import main.java.controller.NewCategoryController;
import main.java.model.Category;
import main.java.model.CurrentState;

import java.util.Optional;

/**
 * Created by wepperson on 7/18/17.
 */
public class CategoryView {

    private static String fxml = "CategoryPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button addCategory, back;

    @FXML
    private TableView<Category> categoriesTable;

    @FXML
    private TableColumn<Category, String> categoryCol, numAttractionsCol, editCol, deleteCol;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        //Calls method to query database and update table
        updateTable();

        back.setOnAction((event -> RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()))));

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
    private void updateTable() {
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("categoryName"));
        numAttractionsCol.setCellValueFactory(
                new PropertyValueFactory<>("numAttractions"));
        editCol.setCellValueFactory(
                new PropertyValueFactory<>("edit"));
        editCol.setSortable(false);
        deleteCol.setCellValueFactory(
                new PropertyValueFactory<>("delete"));
        deleteCol.setSortable(false);

        categoriesTable.setItems(CategoriesListController.buildData());
        editCol.setCellFactory(CategoriesListController.generateCellFactory("edit"));
        deleteCol.setCellFactory(CategoriesListController.generateCellFactory("delete"));
    }
}
