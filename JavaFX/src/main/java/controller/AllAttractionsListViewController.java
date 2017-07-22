package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.AttractionView;
import main.java.view.CityView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by benge on 7/21/2017.
 */
public class AllAttractionsListViewController {
    public static ObservableList<Attraction> buildData() {
        ObservableList<Attraction> data = FXCollections.observableArrayList();
        String attractionQuery =
                "select AttractionName, CName, CityName, AveRating, CountRating " +
                        "from ((select * from rateacity.attraction natural left join rateacity.falls_under " +
                        "natural left join rateacity.city inner join rateacity.reviewable_entity " +
                        "where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) " +
                        "as A inner join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating " +
                        "from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID)";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(attractionQuery);


            while (rs.next()) {
                Attraction attraction = new Attraction(
                        rs.getString("AttractionName"),
                        rs.getString("CName"),
                        rs.getString("CityName"),
                        rs.getString("AveRating"),
                        rs.getString("CountRating")
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
