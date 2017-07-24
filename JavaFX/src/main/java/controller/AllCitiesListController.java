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
        String cityQuery =
                "SELECT CityEID, City, AvgRating, NumRatings, NumAttractions FROM\n" +
                        "(SELECT * FROM\n" +
                        "(SELECT CityEID, CityName AS City, AVG(Rating) AS AvgRating, COUNT(Rating) AS NumRatings\n" +
                        "FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID \n" +
                        "GROUP BY S.CITYEID) AS T \n" +
                        "NATURAL JOIN (SELECT S.CityEID, Count(AttractionEID) as NumAttractions \n" +
                        "FROM RateACity.Attraction AS A RIGHT OUTER JOIN RateACity.City AS S ON A.CityEID = S.CityEID " +
                        "JOIN RATEACITY.REVIEWABLE_ENTITY AS E ON E.EntityID = A.AttractionEID WHERE E.IsPending = 0\n" +
                        "GROUP BY S.CityEID) AS U\n" +
                        "JOIN RateACity.Reviewable_Entity AS R\n" +
                        "WHERE IsPending = 0 AND R.EntityID = CityEID\n" +
                        "ORDER BY City ASC) AS Result;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityQuery);

            while (rs.next()) {
                City city = new City(
                        rs.getString("CityEID"),
                        rs.getString("City"),
                        rs.getString("AvgRating"),
                        rs.getString("NumRatings"),
                        rs.getString("NumAttractions")
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
