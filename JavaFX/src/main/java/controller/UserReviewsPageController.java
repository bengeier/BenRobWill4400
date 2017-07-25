package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import main.java.model.Review;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.ReviewView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wepperson on 7/23/17.
 */
public class UserReviewsPageController {

    public static ObservableList<Review> buildData() {
        ObservableList<Review> data = FXCollections.observableArrayList();
        String query = "SELECT CityName AS EntityName, Rating, Comment, ReviewableEID\n" +
                "FROM \n" +
                "(SELECT * FROM RateACity.CITY AS C JOIN RateACity.REVIEW AS R " +
                "ON C.CityEID=R.ReviewableEID ) \n" +
                "AS UserCityReviews\n" +
                "WHERE UserEmail = '" + CurrentState.getEmail() +"'\n" +
                "UNION\n" +
                "SELECT AttractionName, Rating, Comment, AttractionEID\n" +
                "FROM (SELECT * FROM RateACity.ATTRACTION AS A " +
                "JOIN RateACity.REVIEW AS R ON A.AttractionEID=R.ReviewableEID) " +
                "AS UserAttractionReviews\n" +
                "WHERE UserEmail = '" + CurrentState.getEmail() +"';";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(query);

            while (rs.next()) {
                Review review = new Review(
                        CurrentState.getEmail(),
                        rs.getString("Rating"),
                        rs.getString("Comment"),
                        rs.getString("ReviewableEID"),
                        rs.getString("EntityName")
                );

                data.add(review);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Callback<TableColumn<Review, String>, TableCell<Review, String>> generateCellFactory() {
        return new Callback<TableColumn<Review, String>, TableCell<Review, String>>() {
            @Override
            public TableCell<Review, String> call(TableColumn<Review, String> param) {
                return new TableCell<Review, String>() {
                    final Hyperlink link = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            link.setText("Edit");
                            link.setOnAction(event -> {
                                Review review = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentReview(review);
                                CurrentState.push("UserReviewsPage.fxml");
                                RootView.instance.setCenter(ReviewView.getInstance());
                            });
                            setGraphic(link);
                            setText(null);
                        }
                    }
                };
            }
        };
    }
}
