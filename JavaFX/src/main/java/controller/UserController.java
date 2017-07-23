package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.City;
import main.java.model.User;
import main.java.sql.DBConnection;

import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rob on 7/21/2017.
 */
public class UserController {
    public static ObservableList<City> cityNamesList() {
        return cityNamesList("");
    }

    public static ObservableList<City> cityNamesList(String sort) {
        ObservableList<City> cityNamesList = FXCollections.observableArrayList();

        String cityNamesQuery =
                "SELECT CityEID, CityName FROM RateACity.City \n" +
                "JOIN RateACity.REVIEWABLE_ENTITY ON CITY.CityEID=REVIEWABLE_ENTITY.EntityID \n" +
                "WHERE isPending = 0";
        if (sort.equals("A -> Z")) {
            cityNamesQuery += " ORDER BY CityName ASC";
        } else if (sort.equals("Z -> A")){
            cityNamesQuery += " ORDER BY CityName DESC";
        }

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityNamesQuery);
            while (rs.next()) {
                cityNamesList.add(new City(rs.getString("CityEID"), rs.getString("CityName")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityNamesList;
    }

    public static ObservableList<String> categoriesList() {
        return categoriesList("");
    }

    public static ObservableList<String> categoriesList(String sort) {
        ObservableList<String> categoriesList = FXCollections.observableArrayList();

        String cityNamesQuery = "SELECT CName FROM RateACity.Category";
        if (sort.equals("A -> Z")) {
            cityNamesQuery += " ORDER BY CName ASC";
        } else if (sort.equals("Z -> A")){
            cityNamesQuery += " ORDER BY CName DESC";
        }

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(cityNamesQuery);
            while (rs.next()) {
                categoriesList.add(rs.getString("CName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categoriesList;
    }

    public static ObservableList<User> buildData() {
        ObservableList<User> data = FXCollections.observableArrayList();
        String userQuery =
                "SELECT Email, DateJoined, isManager, isSuspended\n" +
                        "\tFROM RateACity.User;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(userQuery);

            while (rs.next()) {
                String UserClass = "Regular User";
                String isSuspended = "No";
                if (rs.getString("isManager").equals("1")) {
                    UserClass = "Manager";
                }
                if (rs.getString("isSuspended").equals("1")) {
                    isSuspended = "Yes";
                }
                User user = new User(
                        rs.getString("Email"),
                        rs.getString("DateJoined"),
                        UserClass,
                        isSuspended
                );
                data.add(user);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
