package main.java.controller;


import javafx.event.ActionEvent;
import main.java.sql.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Rob on 7/6/2017.
 */
public class LoginController {

    public static boolean login(String email, String password) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        System.out.println(email);
        String loginQuery = "SELECT COUNT(*) FROM RATEACITY.USER WHERE Email='"
                + email + "' AND Password=" + password;
        System.out.println(loginQuery);
        try {
            Statement loginStatement = DBConnection.connection.createStatement();
            ResultSet loginResult = loginStatement.executeQuery(loginQuery);

            return loginResult.next() && loginResult.getString("COUNT(*)").equals("1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
