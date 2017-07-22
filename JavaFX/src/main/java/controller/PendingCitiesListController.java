package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.City;
import main.java.model.PendingCity;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Michael Xiao Local on 7/22/2017.
 */
public class PendingCitiesListController {
    public static ObservableList<PendingCity> buildData() {
        ObservableList<PendingCity> data = FXCollections.observableArrayList();


        String cityQuery = "(SELECT City, Country, UserEmail, Rating, Comment FROM " +
                "(SELECT CityEID, CityName AS City, Country, Rating, Comment " +
                    "FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID) AS T " +
                    "JOIN RateACity.Reviewable_Entity AS R " +
                "WHERE IsPending = 1 AND R.EntityID = CityEID " +
                "ORDER BY City ASC);";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityQuery);

            while (rs.next()) {
                PendingCity pendingCity = new PendingCity(
                        rs.getString("City"),
                        rs.getString("Country"),
                        rs.getString("UserEmail"),
                        rs.getString("Rating"),
                        rs.getString("rating"),
                        rs.getString("comment")
                );
                data.add(pendingCity);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
