package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.City;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerController {

    public static ObservableList<City> cityNamesList() {
        ObservableList<City> cityNamesList = FXCollections.observableArrayList();

        String cityNamesQuery = "SELECT CityEID, CityName, AvgRating FROM\n" +
                "(SELECT CityEID, CityName, AVG(Rating) AS AvgRating\n" +
                "FROM RateACity.Review AS R JOIN RateACity.City AS S ON R.ReviewableEID=S.CityEID\n" +
                "GROUP BY S.CityEID) AS T\n" +
                "JOIN RateACity.Reviewable_Entity AS E ON T.CityEID=E.EntityID\n" +
                "WHERE isPending = 0\n" +
                "ORDER BY CityName ASC;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityNamesQuery);
            while (rs.next()) {
                cityNamesList.add(new City(
                        rs.getString("CityEID"),
                        rs.getString("CityName"),
                        rs.getString("AvgRating")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityNamesList;
    }

    public static ObservableList<String> categoriesList() {
        ObservableList<String> categoriesList = FXCollections.observableArrayList();

        String cityNamesQuery = "SELECT CName FROM RateACity.Category ORDER BY CName ASC";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityNamesQuery);
            while (rs.next()) {
                categoriesList.add(rs.getString("CName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categoriesList;
    }
}
