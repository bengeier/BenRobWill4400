package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.util.Callback;
import main.java.model.PendingAttraction;
import main.java.sql.DBConnection;
import main.java.view.PendingAttractionsView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by Michael Xiao Local on 7/24/2017.
 */
public class PendingAttractionsListController {
    public static ObservableList<PendingAttraction> buildData() {
        ObservableList<PendingAttraction> data = FXCollections.observableArrayList();
        String attractionQuery = "SELECT AttractionEID, AttractionName, CityName, StreetAddress, Country, CName AS Category, Description, Hours, ContactInfo, T.UserEmail, Rating, Comment \n" +
                "FROM \n" +
                "\t(SELECT *\n" +
                "\tFROM RateACity.ATTRACTION AS ATTR JOIN RateACity.REVIEWABLE_ENTITY AS E ON ATTR.AttractionEID = E.EntityID\n" +
                "\tWHERE IsPending = 1) AS T\n" +
                "JOIN RateACity.REVIEW ON REVIEW.UserEmail = T.UserEmail AND REVIEW.ReviewableEID = T.AttractionEID\n" +
                "NATURAL JOIN RATEACITY.CITY\n" +
                "NATURAL LEFT JOIN RATEACITY.CONTACT_INFO\n" +
                "NATURAL JOIN RATEACITY.FALLS_UNDER\n" +
                "NATURAL LEFT JOIN RATEACITY.HOURS_OF_OPERATION\n" +
                "ORDER BY AttractionName;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(attractionQuery);

            while (rs.next()) {
                PendingAttraction pendingAttraction = new PendingAttraction(
                        rs.getString("AttractionEID"),
                        rs.getString("AttractionName"),
                        rs.getString("CityName"),
                        rs.getString("StreetAddress"),
                        rs.getString("Country"),
                        rs.getString("Category"),
                        rs.getString("Description"),
                        rs.getString("Hours"),
                        rs.getString("ContactInfo"),
                        rs.getString("UserEmail"),
                        rs.getString("Rating"),
                        rs.getString("Comment")

                );


                data.add(pendingAttraction);
            }

            
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Callback<TableColumn<PendingAttraction, String>, TableCell<PendingAttraction, String>> generateCellFactory(String column) {
        return new Callback<TableColumn<PendingAttraction, String>, TableCell<PendingAttraction, String>>() {
            @Override
            public TableCell<PendingAttraction, String> call(TableColumn<PendingAttraction, String> param) {
                return new TableCell<PendingAttraction, String>() {
                    final Hyperlink link = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            PendingAttraction attraction = getTableView().getItems().get(getIndex());
                            if (column.equals("approve")) {
                                link.setText("Approve");
                                link.setOnAction(event -> {
                                    if (promptApprove().get() == ButtonType.OK) {
                                        approveAttraction(attraction);
                                        RootView.instance.setCenter(PendingAttractionsView.getInstance());
                                    }
                                });
                            } else if (column.equals("delete")) {
                                link.setText("Delete");
                                link.setOnAction(event -> {
                                    if (promptDelete().get() == ButtonType.OK) {
                                        deletePendingAttraction(attraction);
                                        RootView.instance.setCenter(PendingAttractionsView.getInstance());
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

    private static void approveAttraction(PendingAttraction attraction) {
        String approveUpdate = "UPDATE RateACity.Reviewable_Entity\n" +
                "SET isPending=0\n" +
                "WHERE EntityID=\'" + attraction.getAttractionEID() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(approveUpdate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deletePendingAttraction(PendingAttraction attraction) {
        // Note: deleteReviewStatement would not be necessary if reviews cascade on delete
        String deleteReviewStatement = "DELETE FROM RateACity.Review WHERE ReviewableEID=\'" + attraction.getAttractionEID() + "\';";
        String deletePendingAttractionStatement = "DELETE FROM RateACity.Reviewable_Entity WHERE EntityID=\'" + attraction.getAttractionEID() + "\';";

        try {
            DBConnection.connection.createStatement().executeUpdate(deleteReviewStatement);
            DBConnection.connection.createStatement().executeUpdate(deletePendingAttractionStatement);
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
        return alert.showAndWait();
    }

}
