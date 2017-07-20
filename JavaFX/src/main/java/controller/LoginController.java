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

    /**
     * Handles login logic.
     * @return 0 if login failed. 1 if login succeeded. 2 if login succeeded and user is a manager
     */
    public static int login(String email, String password) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        String loginQuery = "SELECT COUNT(*), IsManager FROM RATEACITY.USER WHERE Email='"
                + email + "' AND Password=" + password;

        try {
            Statement loginStatement = DBConnection.connection.createStatement();
            ResultSet loginResult = loginStatement.executeQuery(loginQuery);

            if (loginResult.next() && loginResult.getString("COUNT(*)").equals("1")) {
                return loginResult.getString("isManager").equals("1") ? 2 : 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
