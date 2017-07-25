package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.CityView;
import main.java.view.FXBuilder;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/21/2017.
 */
public class AllCitiesListController {

    public static ObservableList<City> buildData() {
        ObservableList<City> data = FXCollections.observableArrayList();
        String cityQuery = "select CityEID, CityName, ave, coun, attr from (select CityName, avg(Rating) as ave, count(Rating) as coun, CityEID  from ( " +
                "(select * from rateacity.city join rateacity.reviewable_entity where IsPending=0 AND CityEID=EntityID) as filter) join " +
                "RATEACITY.review where ReviewableEID=CityEID group by CityEid) as c natural left join " +
                "(select CityEid, count(attractionEID) as attr from rateacity.attraction group by CityEID) as final;";


        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityQuery);

            while (rs.next()) {
                City city = new City(
                        rs.getString("CityEID"),
                        rs.getString("CityName"),
                        rs.getString("ave"),
                        rs.getString("coun"),
                        rs.getString("attr")
                );
                data.add(city);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Generates Callback to create a cell factory for city page link column
     * @return Callback to set as CellFactory for city page link column
     */
    public static Callback<TableColumn<City, String>, TableCell<City, String>> generateCellFactory() {
        return new Callback<TableColumn<City, String>, TableCell<City, String>>() {
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
                                CurrentState.push("AllCitiesList.fxml");
                                RootView.instance.setCenter(CityView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
    }
}
