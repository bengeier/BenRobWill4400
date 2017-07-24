package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.util.Callback;
import main.java.model.PendingCity;
import main.java.sql.DBConnection;
import main.java.view.PendingCitiesView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by Michael Xiao Local on 7/24/2017.
 */
public class PendingAttractionsListController {
    public static ObservableList<PendingCity> buildData() {
        return null;
        /*

        ObservableList<PendingCity> data = FXCollections.observableArrayList();

        String cityQuery = "(SELECT CityEID, City, Country, UserEmail, Rating, Comment FROM " +
                "(SELECT CityEID, CityName AS City, Country, Rating, Comment " +
                "FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID) AS T " +
                "JOIN RateACity.Reviewable_Entity AS R " +
                "WHERE IsPending = 1 AND R.EntityID = CityEID " +
                "ORDER BY City ASC);";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityQuery);
            while (rs.next()) {
                PendingCity pendingCity = new PendingCity(
                        rs.getString("CityEID"),
                        rs.getString("City"),
                        rs.getString("Country"),
                        rs.getString("UserEmail"),
                        rs.getString("Rating"),
                        rs.getString("Comment")

                );
                data.add(pendingCity);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Callback<TableColumn<PendingCity, String>, TableCell<PendingCity, String>> generateCellFactory(String column) {
        return new Callback<TableColumn<PendingCity, String>, TableCell<PendingCity, String>>() {
            @Override
            public TableCell<PendingCity, String> call(TableColumn<PendingCity, String> param) {
                return new TableCell<PendingCity, String>() {
                    final Hyperlink link = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            PendingCity city = getTableView().getItems().get(getIndex());
                            if (column.equals("approve")) {
                                link.setText("Approve");
                                link.setOnAction(event -> {
                                    if (promptApprove().get() == ButtonType.OK) {
                                        approveCity(city);
                                        RootView.instance.setCenter(PendingCitiesView.getInstance());
                                    }
                                });
                            } else if (column.equals("delete")) {
                                link.setText("Delete");
                                link.setOnAction(event -> {
                                    if (promptDelete().get() == ButtonType.OK) {
                                        deletePendingCity(city);
                                        RootView.instance.setCenter(PendingCitiesView.getInstance());
                                    }
                                });
                            }
                        }
                        setGraphic(link);
                        setText(null);
                    }
                };
            }
        };
    }

    private static void approveCity(PendingCity city) {
        String approveUpdate = "UPDATE RateACity.Reviewable_Entity\n" +
                "SET isPending=0\n" +
                "WHERE EntityID=\'" + city.getCityEID() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(approveUpdate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deletePendingCity(PendingCity city) {
        // Note: deleteReviewStatement would not be necessary if reviews cascade on delete
        String deleteReviewStatement = "DELETE FROM RateACity.Review WHERE ReviewableEID=\'" + city.getCityEID() + "\';";
        String deletePendingCityStatement = "DELETE FROM RateACity.Reviewable_Entity WHERE EntityID=\'" + city.getCityEID() + "\';";

        try {
            DBConnection.connection.createStatement().executeUpdate(deleteReviewStatement);
            DBConnection.connection.createStatement().executeUpdate(deletePendingCityStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Optional<ButtonType> promptApprove() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Approval");
        alert.setHeaderText("Are You Sure You Want to Approve?");
        alert.setContentText("It will be added to the list of cities.");
        return alert.showAndWait();
    }

    private static Optional<ButtonType> promptDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("Are You Sure You Want to Delete?");
        alert.setContentText("It will be removed from the list of pending cities.");
        return alert.showAndWait();*/
    }
}
