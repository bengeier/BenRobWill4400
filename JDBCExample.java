import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Demo to run a select query on some table.
 * MAKE SURE TO INCLUDE THE JDBC MYSQL DRIVER IN YOUR CLASSPATH
 * (You can do this by adding the .jar as a module in IntelliJ)
 * Created by Rob on 7/18/2017.
 */
public class JDBCExample {
    /**
     * Edit these values depending on your server. DB_DRIVER should not change since we are all using the same JDBC driver
     */
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver"; // the file/package path for the JDBC driver
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/"; // The address for the database server
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "test";

    public static void main(String[] args) {
        try {
            selectFromDbTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void selectFromDbTable() throws SQLException {
        Connection dbConnection = null; // Object representing the Server connection
        Statement statement = null; // Object used for executing queries

        String selectTableSQL = "SELECT * FROM mydb.customer";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL statement
            // ResultSet contains the results of the executed query
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                String userEmail = rs.getString("Email");
                String userName = rs.getString("Name");
                String userCity = rs.getString("City");

                System.out.println("Email:\t" + userEmail + "\n--------");
                System.out.println("Name:\t" + userName + "\n--------");
                System.out.println("City:\t" + userCity + "\n========");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        // Tries loading the Driver
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Try connecting to MySql Server
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
