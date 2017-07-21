package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.City;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/21/2017.
 */
public class AllCitiesListController {

    public static ObservableList<City> buildData() {
        ObservableList<City> data = FXCollections.observableArrayList();
        String cityQuery =
                "SELECT City, AvgRating, NumRatings, NumAttractions FROM\n" +
                        "(SELECT * FROM\n" +
                        "(SELECT CityEID, CityName AS City, AVG(Rating) AS AvgRating, COUNT(Rating) AS NumRatings\n" +
                        "FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID \n" +
                        "GROUP BY S.CITYEID) AS T \n" +
                        "NATURAL JOIN (SELECT S.CityEID, Count(AttractionEID) as NumAttractions \n" +
                        "FROM RateACity.Attraction AS A JOIN RateACity.City AS S ON A.CityEID = S.CityEID\n" +
                        "GROUP BY S.CityEID) AS U\n" +
                        "JOIN RateACity.Reviewable_Entity AS R\n" +
                        "WHERE IsPending = 0 AND R.EntityID = CityEID\n" +
                        "ORDER BY City ASC) AS Result;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityQuery);
            while (rs.next()) {
                City city = new City();
                city.setCity(rs.getString("City"));
                city.setAvgRating(rs.getString("AvgRating"));
                city.setNumRatings(rs.getString("NumRatings"));
                city.setNumAttractions(rs.getString("NumAttractions"));

                data.add(city);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
