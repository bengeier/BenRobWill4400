package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Attraction;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wepperson on 7/24/17.
 */
public class SearchController {

    public static Attraction search() {

        System.out.println("boutta search");

        System.out.println("PARAM: " + CurrentState.getAttractionSearchParam());

        ObservableList<Attraction> data = FXCollections.observableArrayList();


        String attractionQuery = "select StreetAddress, Description, attractionEID, \n" +
                "AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours \n" +
                "from ((select * from rateacity.attraction natural left join RATEACITY.hours_of_operation \n" +
                "natural left join rateacity.contact_info natural left join rateacity.falls_under \n" +
                "natural left join rateacity.city join rateacity.reviewable_entity \n" +
                "where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) \n" +
                "as A join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating \n" +
                "from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID)\n" +
                "where AttractionName=\"" + CurrentState.getAttractionSearchParam() +"\" ";

        if (!(CurrentState.getCurrentCity() == null)
                && !CurrentState.getCurrentCity().equals("")) {
            String add = " and CityName=\"" + CurrentState.getCurrentCity() + "\"";
            attractionQuery += add;
        }

        attractionQuery += ";";

        System.out.println(attractionQuery);


        try {

            ResultSet rs = DBConnection.connection.createStatement()
                    .executeQuery(attractionQuery);

            System.out.println();
            System.out.println("Successfully executed");
            System.out.println();

            if (!rs.next()) {
                return null;
            }

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

            data = combineCategories(data);

            if (!(CurrentState.getCurrentCategory() == null)
                    && !CurrentState.getCurrentCategory().equals("")) {

                if (!data.get(0).getCategoryList().contains(CurrentState.getCurrentCategory())) {
                    return null;
                }

            }

            return data.get(0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static ObservableList<Attraction> combineCategories(ObservableList<Attraction> toCombine) {

        ObservableList<Attraction> toReturn = FXCollections.observableArrayList();
        for (Attraction a : toCombine) {
            toReturn.add(a);
        }
        for (int i = 0; i < toReturn.size() - 1; i++) {
            Attraction first = toReturn.get(i);
            Attraction second = toReturn.get(i+1);
            if (first.getAttractionEID().equals(second.getAttractionEID())) {

                for (String s : second.getCategoryList()) {
                    first.addCategory(s);
                }
                toReturn.remove(i+1);
                i--;
            }
        }
        return toReturn;
    }
}
