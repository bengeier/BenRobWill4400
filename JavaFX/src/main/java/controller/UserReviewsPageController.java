package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.CurrentState;
import main.java.model.Review;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wepperson on 7/23/17.
 */
public class UserReviewsPageController {

    public static ObservableList<Review> buildData() {
        ObservableList<Review> data = FXCollections.observableArrayList();
        String query = "SELECT CityName, Rating, Comment\n" +
                "FROM \n" +
                "(SELECT * FROM RateACity.CITY AS C JOIN RateACity.REVIEW AS R " +
                "ON C.CityEID=R.ReviewableEID ) \n" +
                "AS UserCityReviews\n" +
                "WHERE UserEmail = '" + CurrentState.getEmail() +"'\n" +
                "UNION\n" +
                "SELECT AttractionName, Rating, Comment \n" +
                "FROM (SELECT * FROM RateACity.ATTRACTION AS A " +
                "JOIN RateACity.REVIEW AS R ON A.AttractionEID=R.ReviewableEID) " +
                "AS UserAttractionReviews\n" +
                "WHERE UserEmail = '" + CurrentState.getEmail() +"';";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(query);

            while (rs.next()) {
                Review review = new Review(
                        rs.getString("CityName"),
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
