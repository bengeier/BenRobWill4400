package main.java.controller;

import main.java.model.CurrentState;
import main.java.sql.DBConnection;

import java.sql.SQLException;

/**
 * Created by wepperson on 7/25/17.
 */
public class DeleteCityController {

    public static int deleteCurrentCity() {
        String promoteQuery = "DELETE FROM RateACity.REVIEWABLE_ENTITY WHERE EntityID=" + CurrentState.getCurrentCity().getCityEID() + " ;";

        System.out.println(promoteQuery);

        try {
            DBConnection.connection.createStatement().executeUpdate(promoteQuery);
            return 1;
        } catch (SQLException e) {
            e.getMessage();
            return 0;
        }

    }
}
