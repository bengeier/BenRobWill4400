package main.java.controller;

import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/22/2017.
 */
public class NewCityController {

    public static boolean addNewCity(String name, String country, String state, String rating, String comment) {
        String insertReviewableQuery =
                "INSERT INTO RateACity.Reviewable_Entity(isPending, userEmail)" +
                        " OUTPUT Inserted.EntityID" +
                        " VALUES(" + (CurrentState.isManagerView() ? 0 : 1) + ", " + CurrentState.getEmail() + ")";
        String insertCityQuery;
        try {
            DBConnection.connection.createStatement().executeQuery(insertReviewableQuery);
            if (state.length() == 0) {
                insertCityQuery = "INSERT INTO RateACity.City(CityEID, CityName, Country)"
                        + " VALUES(LAST_INSERT_ID(), " + name + ", " + country + ")";
            } else {
                insertCityQuery = "INSERT INTO RateACity.City(CityEID, CityName, Country, State)"
                        + " VALUES(LAST_INSERT_ID(), " + name + ", " + country + ", " + state + ")";
            }
            DBConnection.connection.createStatement().executeQuery(insertCityQuery);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
