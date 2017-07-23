package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.controller.NewCategoryController;
import main.java.model.Category;
import main.java.model.City;
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
    private TableView<Category> categoriesTable;

    @FXML
    private TableColumn<Category, String> categoryCol, numAttractionsCol, editCol, deleteCol;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        //Calls method to query database and update table
        updateTable();

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
    private void updateTable() {
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("categoryName"));
        numAttractionsCol.setCellValueFactory(
                new PropertyValueFactory<>("numAttractions"));

        /*
            Unfortunately this code works. You could probably refactor it idk
         */
        /*link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        Callback<TableColumn<City, String>, TableCell<City, String>> cellFactory
                = new Callback<TableColumn<City, String>, TableCell<City, String>>() {
            @Override
            public TableCell<City, String> call(TableColumn<City, String> param) {
                return new TableCell<City, String>() {
                    final Hyperlink pageLink = new Hyperlink("City Page");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pageLink.setOnAction(event -> {
                                City city = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentCity(city);
                                CurrentState.push(fxml);
                                RootView.instance.setCenter(CityView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
        link.setCellFactory(cellFactory);*/
        categoriesTable.setItems(CategoriesListController.buildData());
    }
}
