package main.java.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllAttractionsListViewController;
import main.java.controller.CityViewController;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import org.omg.CORBA.Current;

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

    @FXML
    public void initialize() {
        updateTable();

        cityName.setText(CurrentState.getCurrentCity().getCityName());
        cityAndCategory.setText(CurrentState.getCurrentCategory()
                + " Attractions in " + CurrentState.getCurrentCity().getCityName());

        avgRatingText.setText(CurrentState.getCurrentCity().getAvgRating() + "/5");

        reviewThisCity.setOnAction((event -> {
            if (!CurrentState.isSuspended()) {
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
        Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>> cellFactory
                = new Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>>() {
            @Override
            public TableCell<Attraction, String> call(TableColumn<Attraction, String> param) {
                return new TableCell<Attraction, String>() {
                    final Hyperlink pageLink = new Hyperlink("Page");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pageLink.setOnAction(event -> {
                                Attraction attraction = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentAttraction(attraction);
                                CurrentState.push(fxml);
                                RootView.instance.setCenter(AttractionView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
        infoCol.setCellFactory(cellFactory);

        ObservableList<Attraction> forTable = combineCategories(CityViewController.buildData());
        table.setItems(forTable);
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
                first.setCategory(first.getCategory() + ", " + second.getCategory());
                toReturn.remove(i+1);
                i--;
            }
        }
        return toReturn;
    }
}
