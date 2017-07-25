package main.java.controller;

import javafx.scene.control.Alert;
import main.java.model.CurrentState;
import main.java.model.Review;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewViewController {
    public static boolean addNewReview(String email, String reviewableEID, String rating, String comment) {
        String addReviewQuery = "INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES " +
                "(\'" + email + "\', \'" + reviewableEID + "\', \'" +  rating + "\', \'" + comment + "\');";
        try {
            DBConnection.connection.createStatement().executeUpdate(addReviewQuery);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());

            if (e.getErrorCode() == 1062) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Review Already Written");
                alert.setHeaderText("Only one review per user.");
                alert.setContentText("You have already written a review for this location.");

                alert.showAndWait();
            }
        }
        return false;
    }

    public static void deleteReview(Review review) {
        String reviewDelete = "DELETE FROM RateACity.Review\n" +
                "WHERE ReviewableEID=\'" + review.getReviewableEID() + "\' " +
                "AND UserEmail=\'" + review.getUserEmail() + "\';";

        try {
            DBConnection.connection.createStatement().executeUpdate(reviewDelete);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isNewReview(String entityID) {
        String reviewedQuery = "SELECT COUNT(*) FROM RateACity.Review\n" +
                "WHERE UserEmail='" + CurrentState.getEmail() + "'\n" +
                "AND ReviewableEID='" + entityID + "';";

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
