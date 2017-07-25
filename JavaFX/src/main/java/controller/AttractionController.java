package main.java.controller;

import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/25/2017.
 */
public class AttractionController {
    public static boolean isNewReview() {
        String reviewedQuery = "SELECT COUNT(*) FROM RateACity.Review\n" +
                "WHERE UserEmail='" + CurrentState.getEmail() + "'\n" +
                "AND ReviewableEID='" + CurrentState.getCurrentAttraction().getAttractionEID() + "';";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(reviewedQuery);
            if (rs.next()) {
                return rs.getString("COUNT(*)").equals("0");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
