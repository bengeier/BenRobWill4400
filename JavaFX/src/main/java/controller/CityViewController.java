package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.AttractionView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityViewController {
    public static ObservableList<Attraction> buildData() {
        ObservableList<Attraction> data = FXCollections.observableArrayList();
        String currentCategory = CurrentState.getCurrentCategory();
        // Note: this query properly sorts attractions if a category is specified, but the listed attraction(s) only
        //       have the selected category listed as their category
        String attractionQuery =
                "select StreetAddress, Description, attractionEID, AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours " +
                        "from ((select * from rateacity.attraction natural left join RATEACITY.hours_of_operation " +
                        "natural left join rateacity.contact_info natural left join rateacity.falls_under " +
                        "natural left join rateacity.city inner join rateacity.reviewable_entity " +
                        "where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0 " +
                        "AND city.CityEID=" + CurrentState.getCurrentCity().getCityEID() +
                        (currentCategory.equals("") ? " " : " AND CName=\'" + currentCategory + "\'") +
                        ") as A inner join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating " +
                        "from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID)" +
                        " ORDER BY attractionEID;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(attractionQuery);


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

    /**
     * Generates Callback to create a cell factory for city attraction link column
     * @return Callback to set as CellFactory for attraction link column
     */
    public static Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>> generateCellFactory() {
        return new Callback<TableColumn<Attraction, String>, TableCell<Attraction, String>>() {
            @Override
            public TableCell<Attraction, String> call(TableColumn<Attraction, String> param) {
                return new TableCell<Attraction, String>() {
                    final Hyperlink pageLink = new Hyperlink("Page");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pageLink.setOnAction(event -> {
                                Attraction attraction = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentAttraction(attraction);
                                CurrentState.push("CityPage.fxml");
                                RootView.instance.setCenter(AttractionView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
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
