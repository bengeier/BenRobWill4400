package main.java.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import main.java.controller.AllAttractionsListViewController;
import main.java.controller.CityViewController;
import main.java.controller.DeleteCityController;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.model.Review;
import org.omg.CORBA.Current;
import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

import java.util.Optional;

public class CityView {

    private static String fxml = "CityPage.fxml";

    public static BorderPane getInstance() {
        return (BorderPane) FXBuilder.getFXMLView(fxml);
    }

    @FXML
    private Button reviewThisCity, viewAllReviews, back;

    @FXML
    private Label cityName, cityAndCategory, avgRatingText;

    @FXML
    private TableView<Attraction> table;

    @FXML
    private TableColumn<Attraction, String> nameCol, addressCol, categoryCol, avgCol, numRatCol, infoCol;

    private TableColumn<Attraction, String> deleteCol = new TableColumn<>("Delete");

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        updateTable();

        cityName.setText(CurrentState.getCurrentCity().getCityName());
        cityAndCategory.setText(CurrentState.getCurrentCategory()
                + " Attractions in " + CurrentState.getCurrentCity().getCityName());

        avgRatingText.setText(CurrentState.getCurrentCity().getAvgRating() + "/5");

        reviewThisCity.setText(
                CityViewController.isNewReview(CurrentState.getCurrentCity().getCityEID()) ?
                        "Review This City" : "Edit Review"
        );
        reviewThisCity.setOnAction((event -> {
            if (!CurrentState.isSuspended()) {
                CurrentState.setCurrentReview(new Review(
                        CurrentState.getEmail(),
                        CurrentState.getCurrentCity().getCityEID()
                ));
                CurrentState.push(fxml);
                RootView.instance.setCenter(ReviewView.getInstance());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Submit Review");
                alert.setHeaderText("Suspended Users Cannot Submit Reviews.");
                alert.setContentText("Please contact a manager if you wish to remove suspension.");
                alert.showAndWait();
            }
        }));

        viewAllReviews.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(CityAllReviewView.getInstance());
        }));

        back.setOnAction((event -> RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()))));

        if (CurrentState.isManagerView()) {
            Button delete = new Button();
            delete.setText("Delete This City");

            GridPane.setConstraints(delete, 1, 0);

            gridPane.getChildren().add(delete);

            delete.setOnAction((event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Delete City");
                alert.setHeaderText("Are You Sure?");
                alert.setContentText("Deleting your account will get rid of all information f" +
                        "or this city including any reviews.");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {

                    deleteCity();
                }

            }));


        }
    }

    private void updateTable() {
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("attractionName"));
        addressCol.setCellValueFactory(
                new PropertyValueFactory<>("address"));
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        avgCol.setCellValueFactory(
                new PropertyValueFactory<>("aveRating"));
        numRatCol.setCellValueFactory(
                new PropertyValueFactory<>("numRatings"));
        infoCol.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        infoCol.setSortable(false);
        
        ObservableList<Attraction> forTable = combineCategories(CityViewController.buildData());
        table.setItems(forTable);

        infoCol.setCellFactory(CityViewController.generateCellFactory("page"));
        if (CurrentState.isManagerView()) {
            table.getColumns().add(deleteCol);
            deleteCol.setCellValueFactory(
                    new PropertyValueFactory<>("delete"));
            deleteCol.setCellFactory(CityViewController.generateCellFactory("delete"));
        }
    }

    private ObservableList<Attraction> combineCategories(ObservableList<Attraction> toCombine) {

        ObservableList<Attraction> toReturn = FXCollections.observableArrayList();
        for (Attraction a : toCombine) {
            toReturn.add(a);
        }
        for (int i = 0; i < toReturn.size() - 1; i++) {
            Attraction first = toReturn.get(i);
            Attraction second = toReturn.get(i+1);
            if (first.getAttractionEID().equals(second.getAttractionEID())) {

                for (String s : second.getCategoryList()) {
                    first.addCategory(s);
                }
                toReturn.remove(i+1);
                i--;
            }
        }
        return toReturn;
    }

    private void deleteCity() {
        if (DeleteCityController.deleteCurrentCity() == 1) {
            // success
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        } else {
            cityAndCategory.setText("Error deleting!");
        }
    }
}
