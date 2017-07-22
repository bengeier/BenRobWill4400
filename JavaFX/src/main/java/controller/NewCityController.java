package main.java.controller;

import java.sql.Statement;

import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/22/2017.
 */
public class NewCityController {

    public static boolean addNewCity(String name, String country, String state, String rating, String comment) {

        // Creates Reviewable_Entity
        String insertReviewableQuery =
                "INSERT INTO RateACity.Reviewable_Entity(isPending, userEmail)" +
                        " VALUES (" + (CurrentState.isManagerView() ? 0 : 1) + ", \'" + CurrentState.getEmail() + "\');";
        String insertCityQuery;
        int lastIndex = -1;
        try {
            Statement stmt = DBConnection.connection.createStatement();
            stmt.executeUpdate(insertReviewableQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                lastIndex = rs.getInt(1);
            }
            rs.close();
            stmt.close();

            CurrentState.setCurrentCity(new City(((Integer) lastIndex).toString(), name, rating, "1", "0"));

            // Creates City
            if (state.length() == 0) {
                insertCityQuery = "INSERT INTO RateACity.City(CityEID, CityName, Country)"
                        + " VALUES (" + lastIndex + ", \'" + name + "\', \'" + country + "\');";
                System.out.println(insertCityQuery);
            } else {
                insertCityQuery = "INSERT INTO RateACity.City(CityEID, CityName, Country, State)"
                        + " VALUES (" + lastIndex + ", \'" + name + "\', \'" + country + "\', \'" + state + "\');";
            }

            DBConnection.connection.createStatement().executeUpdate(insertCityQuery);

            // Creates first review
            String insertReviewQuery = "INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES " +
                    "( \'" + CurrentState.getEmail() +"\', \'" + lastIndex + "\', \'" + rating + "\', \'" + comment + "\');";

            DBConnection.connection.createStatement().executeUpdate(insertReviewQuery);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
