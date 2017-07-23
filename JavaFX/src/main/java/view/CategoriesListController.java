package main.java.view;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Category;
import main.java.model.City;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;
import main.java.view.CityView;
import main.java.view.FXBuilder;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Michael Xiao Local on 7/23/2017.
 */
public class CategoriesListController {

    public static ObservableList<Category> buildData() {
        ObservableList<Category> data = FXCollections.observableArrayList();
        String categoryQuery =
                "SELECT CName as Category, COUNT(*) AS NumAttractions\n" +
                        "\tFROM RateACity.CATEGORY \n" +
                        "    NATURAL JOIN RateACity.FALLS_UNDER\n" +
                        "    NATURAL JOIN RateACity.ATTRACTION\n" +
                        "\tGROUP BY Category\n" +
                        "    ;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(categoryQuery);

            while (rs.next()) {
                Category category = new Category(
                        rs.getString("Category"),
                        rs.getString("NumAttractions")
                );
                data.add(category);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

