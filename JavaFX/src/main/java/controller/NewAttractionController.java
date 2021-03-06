package main.java.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Attraction;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewAttractionController {

    public static ObservableList<City> getCities() {
        ObservableList<City> cityNamesList = FXCollections.observableArrayList();
        String cityNamesQuery = "SELECT CityEID, CityName, AvgRating FROM\n" +
                "(SELECT CityEID, CityName, AVG(Rating) AS AvgRating\n" +
                "FROM RateACity.Review AS R JOIN RateACity.City AS S ON R.ReviewableEID=S.CityEID\n" +
                "GROUP BY S.CityEID) AS T\n" +
                "JOIN RateACity.Reviewable_Entity AS E ON T.CityEID=E.EntityID\n" +
                "WHERE isPending = 0\n" +
                "ORDER BY CityName ASC;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityNamesQuery);
            while (rs.next()) {
                cityNamesList.add(new City(
                        rs.getString("CityEID"),
                        rs.getString("CityName"),
                        rs.getString("AvgRating")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityNamesList;
    }

    public static ObservableList<String> getCategories() {
        ObservableList<String> categoriesList = FXCollections.observableArrayList();
        String getCategoriesQuery = "Select CName from rateacity.category ORDER BY CName ASC";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(getCategoriesQuery);
            while (rs.next()) {
                categoriesList.add(rs.getString("CName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categoriesList;
    }

    public static boolean addNewAttraction (String name, String address, String description,
                                            String hours, String contact, String comment,
                                            City city, String category, String rating) {

        // Creates reviewable entity
        String insertReviewableQuery = "INSERT INTO RateACity.Reviewable_Entity(isPending, userEmail)" +
                " VALUES (" + (CurrentState.isManagerView() ? 0 : 1) + ", \'" + CurrentState.getEmail() + "\');";
        int lastIndex = -1;
        try {
            Statement stmt = DBConnection.connection.createStatement();
            stmt.executeUpdate(insertReviewableQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                lastIndex = rs.getInt(1);
            }
            rs.close();

            CurrentState.setCurrentAttraction(new Attraction(((Integer) lastIndex).toString(), name, category,
                    description, hours, address, city.getCityName(), rating, "1", contact));

            // Creates Attraction
            String insertAttractionQuery = "INSERT INTO RateACity.Attraction (AttractionEID, CityEID, StreetAddress, AttractionName, Description)" +
                    " VALUES (" + lastIndex + ", " + city.getCityEID() +
                    ", \'" + address + "\', \'" + name + "\', \'" + description + "\');";

            stmt.executeUpdate(insertAttractionQuery);

            // Creates first review
            String insertReviewQuery = "INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES " +
                    "(\'" + CurrentState.getEmail() +"\', \'" + lastIndex + "\', \'" + rating + "\', \'" + comment + "\');";
            stmt.executeUpdate(insertReviewQuery);

            // Creates contact info
            String insertContactInfoQuery = "INSERT INTO RateACity.contact_info (ContactInfo, AttractionEID) VALUES " +
                    "(\'" + contact + "\', " + lastIndex + ");";
            stmt.executeUpdate(insertContactInfoQuery);

            // Creates Hours of Operation
            String insertHoursQuery = "INSERT INTO RateACity.hours_of_operation (AttractionEID, Hours) VALUES " +
                    "(" + lastIndex + ", \'" + hours + "\')";
            stmt.executeUpdate(insertHoursQuery);

            String insertCategoryQuery = "INSERT INTO RateACity.Falls_Under (AttractionEID, CName) VALUES " +
                    "(" + lastIndex + ", \'" + category + "\');";
            stmt.executeUpdate(insertCategoryQuery);

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
