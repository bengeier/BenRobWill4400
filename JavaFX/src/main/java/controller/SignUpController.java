package main.java.controller;

import main.java.sql.DBConnection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SignUpController {

    /**
     * Handles sign up logic.
     * @return 0 if sign up failed, 1 if successful
     */
    public static int signUp(String email, String password) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }

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

        String query = "INSERT INTO RATEACITY.USER (Email, Password) VALUES (\"" + email + "\", \"" + password + "\"" + ");";

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
