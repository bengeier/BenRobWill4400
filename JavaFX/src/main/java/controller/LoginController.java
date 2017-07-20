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
        String loginQuery = "SELECT COUNT(*) FROM RATEACITY.USER WHERE Email='"
                + email + "' AND Password=" + password;
        try {
            Statement loginStatement = DBConnection.connection.createStatement();
            ResultSet loginResult = loginStatement.executeQuery(loginQuery);

            if (loginResult.next() && loginResult.getString("COUNT(*)").equals("1")) {
                return isManager(email, password) ? 2 : 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /**
     * Runs SQL query to determine if user is a manager or not
     * @return true if user is manager, false if not
     */
    private static boolean isManager(String email, String password) throws SQLException {

        // TODO is this method really necessary??

        String isManagerQuery = "SELECT COUNT(*) FROM RATEACITY.USER WHERE Email='"
                + email +"' AND Password=" + password + " AND isManager=1";
        Statement isManagerStatement = DBConnection.connection.createStatement();
        ResultSet isManagerResult = isManagerStatement.executeQuery(isManagerQuery);
        return isManagerResult.next() && isManagerResult.getString("COUNT(*)").equals("1");
    }
}
