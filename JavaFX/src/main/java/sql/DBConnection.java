package main.java.sql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class that has a static database connection. Call createConnection() once and you should be able to reference
 * the static connection variable whenever interacting with database.
 * Created by Rob on 7/18/2017.
 */
public class DBConnection {
    // Reference this to access the database
    public static Connection connection = null;

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver"; // the file/package path for the JDBC driver
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/"; // The address for the database server
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "thomasepp";

    public static void createConnection() {
        try {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver\n" + e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Successfully Connected to Database!");
        } catch(SQLException e) {
            System.out.println("Failed to connect:\n" + e.getMessage());
        }
    }
}
