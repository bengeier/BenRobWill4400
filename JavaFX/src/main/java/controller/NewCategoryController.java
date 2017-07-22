package main.java.controller;

import main.java.sql.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Michael Xiao Local on 7/22/2017.
 */
public class NewCategoryController {

    /**
     * Handles category adding logic
     * @return 0 if category addition failed, 1 if successful
     */
    public static int addCategory(String Cname) {
        if (Cname == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }
        String query = "INSERT INTO RateACity.CATEGORY (CNAME) VALUES (\"" + Cname + "\");";
        try {
            Statement stmt = DBConnection.connection.createStatement();
            int res = stmt.executeUpdate(query);
            System.out.println("Successfully inserted!");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
