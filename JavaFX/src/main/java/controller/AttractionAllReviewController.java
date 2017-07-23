package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.model.Review;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wepperson on 7/23/17.
 */
public class AttractionAllReviewController {

    public static ObservableList<Review> buildData() {
        ObservableList<Review> data = FXCollections.observableArrayList();
        String query = "SELECT R.UserEmail, R.Rating, R.Comment\n" +
                "FROM RateACity.REVIEW AS R \n" +
                "JOIN RATEACITY.REVIEWABLE_ENTITY AS E \n" +
                "ON (R.ReviewableEID = E.EntityID)\n" +
                "JOIN RATEACITY.ATTRACTION AS A ON (A.AttractionEID = E.EntityID)\n" +
                "WHERE E.IsPending = 0 AND A.AttractionName = \""
                + CurrentState.getCurrentAttraction().getAttractionName() + " \";";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(query);

            while (rs.next()) {
                Review review = new Review(
                        rs.getString("UserEmail"),
                        rs.getString("Rating"),
                        rs.getString("Comment")

                );

                data.add(review);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
