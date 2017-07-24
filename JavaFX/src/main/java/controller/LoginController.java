package main.java.controller;


import javafx.event.ActionEvent;
import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginController {

    /**
     * Handles login logic.
     * @return 0 if login failed. 1 if login succeeded. 2 if login succeeded and user is a manager
     */
    public static int login(String email, String password) {

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            password = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        String loginQuery = "SELECT COUNT(*), IsManager, IsSuspended FROM RATEACITY.USER WHERE Email='"
                + email + "' AND Password=\"" + password + "\"";

        try {
            Statement loginStatement = DBConnection.connection.createStatement();
            ResultSet loginResult = loginStatement.executeQuery(loginQuery);

            if(!loginResult.next()) {
                return 0;
            } else {
                if (loginResult.getString("isSuspended").equals("1")) {
                    CurrentState.setSuspended(true);
                }
                if (loginResult.getString("COUNT(*)").equals("1")) {
                    return loginResult.getString("isManager").equals("1") ? 2 : 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return 0;
    }
}
