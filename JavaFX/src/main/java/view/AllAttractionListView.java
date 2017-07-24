package main.java.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllAttractionsListViewController;
import main.java.model.Attraction;
import main.java.model.CurrentState;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wepperson on 7/18/17.
 */
public class AllAttractionListView {

    private static String fxml = "AllAttractionList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    private Button add, back;

    @FXML
    private Label categoryLabel;

    @FXML
    private TableView<Attraction> attractionsTable;

    @FXML
    private TableColumn<Attraction, String> nameCol, categoryCol, locationCol, avgCol, numCol, link;

    @FXML
    public void initialize() {
        updateTable();

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        add.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(NewAttractionView.getInstance());
        }));
    }

    private void updateTable() {
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("attractionName"));
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        locationCol.setCellValueFactory(
                new PropertyValueFactory<>("city"));
        avgCol.setCellValueFactory(
                new PropertyValueFactory<>("aveRating"));
        numCol.setCellValueFactory(
                new PropertyValueFactory<>("numRatings"));
        /*
            Unfortunately this code works. You could probably refactor it idk
         */
        link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
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
        link.setCellFactory(cellFactory);

        ObservableList<Attraction> forTable = combineCategories(AllAttractionsListViewController.buildData());


        //  check here for if matches search category
        if (!CurrentState.getCurrentCategory().equals("") && !CurrentState.getCurrentCategory().equals(null)) {

            categoryLabel.setText("Showing attractions for Category: " + CurrentState.getCurrentCategory());

            Iterator<Attraction> itr = forTable.iterator();
            while (itr.hasNext()) {
                if (!itr.next().getCategoryList().contains(CurrentState.getCurrentCategory())) {
                    itr.remove();
                }
            }
        }

        attractionsTable.setItems(forTable);
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
}
