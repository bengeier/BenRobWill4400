package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import main.java.model.CurrentState;
import main.java.model.Review;
import main.java.sql.DBConnection;
import main.java.view.CityAllReviewView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wepperson on 7/23/17.
 */
public class CityAllReviewController {

    public static ObservableList<Review> buildData() {
        ObservableList<Review> data = FXCollections.observableArrayList();
        String query = "SELECT R.UserEmail, R.Rating, R.Comment\n" +
                "FROM RateACity.REVIEW AS R \n" +
                "JOIN RateACity.REVIEWABLE_ENTITY AS E \n" +
                "ON (R.ReviewableEID = E.EntityID)\n" +
                "WHERE E.IsPending = 0 AND E.EntityID = "
                + CurrentState.getCurrentCity().getCityEID() + ";";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(query);

            while (rs.next()) {
                Review review = new Review(
                        rs.getString("UserEmail"),
                        rs.getString("Rating"),
                        rs.getString("Comment"),
                        CurrentState.getCurrentCity().getCityEID(),
                        CurrentState.getCurrentCity().getCityName()
                );

                data.add(review);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Callback<TableColumn<Review, String>, TableCell<Review, String>> generateCellFactory(String column) {
        return new Callback<TableColumn<Review, String>, TableCell<Review, String>>() {

            @Override
            public TableCell<Review, String> call(TableColumn<Review, String> param) {
                return new TableCell<Review, String>() {
                    final Hyperlink pageLink = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            Review review = getTableView().getItems().get(getIndex());

                            if (column.equals("delete")) {
                                pageLink.setText("Delete");
                                pageLink.setOnAction(event -> {
                                    deleteReview(review);
                                    RootView.instance.setCenter(CityAllReviewView.getInstance());
                                });
                            }
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
    }

    private static int deleteReview(Review review) {


        String deleteStatement = "DELETE FROM RateACity.REVIEW WHERE UserEmail= \""
                + review.getUserEmail() +"\" and ReviewableEID=" + review.getReviewableEID() +";\n";
        try {
            DBConnection.connection.createStatement().executeUpdate(deleteStatement);
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
