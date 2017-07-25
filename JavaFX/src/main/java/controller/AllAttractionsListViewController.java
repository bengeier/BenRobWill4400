package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.AllAttractionListView;
import main.java.view.AttractionView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllAttractionsListViewController {
    public static ObservableList<Attraction> buildData() {
        ObservableList<Attraction> data = FXCollections.observableArrayList();
        String attractionQuery = "SELECT * FROM (\n" +
                "select StreetAddress, Description, attractionEID, AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours\n" +
                "                    from (select * from rateacity.attraction natural left join RATEACITY.hours_of_operation\n" +
                "                    natural left join rateacity.contact_info natural left join rateacity.falls_under\n" +
                "                    natural left join rateacity.city inner join rateacity.reviewable_entity\n" +
                "                    where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0)\n" +
                "                    as A inner join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating\n" +
                "                    from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID) AS B\n" +
                "\tORDER BY CityName; ";

        try {
            ResultSet rs = DBConnection.connection.createStatement()
                    .executeQuery(attractionQuery);



            while (rs.next()) {
                Attraction attraction = new Attraction(
                        rs.getString("attractionEID"),
                        rs.getString("AttractionName"),
                        rs.getString("CName"),
                        rs.getString("Description"),
                        rs.getString("Hours"),
                        rs.getString("StreetAddress"),
                        rs.getString("CityName"),
                        rs.getString("AveRating"),
                        rs.getString("CountRating"),
                        rs.getString("ContactInfo")
                );

                data.add(attraction);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>> generateCellFactory(String column) {
        return new Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>>() {
            @Override
            public TableCell<Attraction, String> call(TableColumn<Attraction, String> param) {
                return new TableCell<Attraction, String>() {
                    final Hyperlink pageLink = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            Attraction attraction = getTableView().getItems().get(getIndex());
                            if (column.equals("page")) {
                                pageLink.setText("Page");
                                pageLink.setOnAction(event -> {
                                    CurrentState.setCurrentAttraction(attraction);
                                    CurrentState.push("AllAttractionList.fxml");
                                    RootView.instance.setCenter(AttractionView.getInstance());
                                });
                            } else if (column.equals("delete")) {
                                pageLink.setText("Delete");
                                pageLink.setOnAction(event -> {
                                    deleteAttraction(attraction);
                                    RootView.instance.setCenter(AllAttractionListView.getInstance());
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

    private static void deleteAttraction(Attraction attraction) {
        String deleteStatement = "DELETE FROM RateACity.Attraction\n" +
                "WHERE AttractionEID=\'" + attraction.getAttractionEID() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(deleteStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
