package main.java.controller;

import javafx.scene.control.Alert;
import main.java.sql.DBConnection;

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
}
