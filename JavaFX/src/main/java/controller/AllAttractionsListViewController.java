package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Attraction;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllAttractionsListViewController {
    public static ObservableList<Attraction> buildData() {
        ObservableList<Attraction> data = FXCollections.observableArrayList();
        String attractionQuery =
                "select StreetAddress, Description, attractionEID, AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours " +
                "from ((select * from rateacity.attraction natural left join RATEACITY.hours_of_operation " +
                "natural left join rateacity.contact_info natural left join rateacity.falls_under " +
                "natural left join rateacity.city inner join rateacity.reviewable_entity " +
                "where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) " +
                "as A inner join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating " +
                "from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID); ";

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
}
