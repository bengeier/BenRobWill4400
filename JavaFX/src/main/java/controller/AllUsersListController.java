package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.util.Callback;
import main.java.model.CurrentState;
import main.java.model.User;
import main.java.sql.DBConnection;
import main.java.view.AllUsersListView;
import main.java.view.RootView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by Rob on 7/24/2017.
 */
public class AllUsersListController {
    public static ObservableList<User> buildData() {
        ObservableList<User> data = FXCollections.observableArrayList();
        String userQuery =
                "SELECT Email, DateJoined, isManager, isSuspended\n" +
                        "\tFROM RateACity.User;";

        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(userQuery);

            while (rs.next()) {
                String UserClass = "Regular User";
                String isSuspended = "No";
                if (rs.getString("isManager").equals("1")) {
                    UserClass = "Manager";
                }
                if (rs.getString("isSuspended").equals("1")) {
                    isSuspended = "Yes";
                }
                User user = new User(
                        rs.getString("Email"),
                        rs.getString("DateJoined"),
                        UserClass,
                        isSuspended
                );
                data.add(user);
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Generates callback for a Cell Factory for a column object.
     * The cell factory will generate relevant hyperlinks for each table row
     * @param column column name to generate cell factory for.
     *               "userClass" returns hyperlinks with each user's class with a prompt for promotion/demotion
     *               "suspended" returns hyperlinks with each user's suspension status with a prompt for suspension/removal
     *               "delete" returns hyperlinks that prompt to delete the user
     * @return Callback to set as column's cellfactory
     */
    public static Callback<TableColumn<User, String>, TableCell<User, String>> generateCellFactory(String column) {
        return new Callback<TableColumn<User, String>, TableCell<User, String>>() {
            @Override
            public TableCell<User, String> call(TableColumn<User, String> param) {
                return new TableCell<User, String>() {
                    final Hyperlink link = new Hyperlink("");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            User user = getTableView().getItems().get(getIndex());
                            switch (column) {
                                case "userClass":
                                    link.setText(user.getUserClass());
                                    link.setOnAction(event -> {
                                        if (user.getUserClass().equals("Regular User")) {
                                            if (promptForPromote().get() == ButtonType.OK) {
                                                promoteUser(user);
                                                RootView.instance.setCenter(AllUsersListView.getInstance());
                                            }
                                        } else {
                                            if (onlyOneManager()) {
                                                displayManagerError();
                                            } else if (promptForDemote().get() == ButtonType.OK) {
                                                demoteUser(user);
                                                RootView.instance.setCenter(AllUsersListView.getInstance());
                                            }
                                        }
                                    });
                                    break;
                                case "suspended":
                                    link.setText(user.getSuspended());
                                    link.setOnAction(event -> {
                                        if (user.getSuspended().equals("Yes")) {
                                            if (promptForSuspensionRemoval().get() == ButtonType.OK) {
                                                removeSuspension(user);
                                                RootView.instance.setCenter(AllUsersListView.getInstance());
                                            }
                                        } else {
                                            if (promptForSuspension().get() == ButtonType.OK) {
                                                suspend(user);
                                                RootView.instance.setCenter(AllUsersListView.getInstance());
                                            }
                                        }
                                    });
                                    break;
                                case "delete":
                                    link.setText("Delete");
                                    link.setOnAction(event -> {
                                        if (onlyOneManager()) {
                                            displayManagerError();
                                        } else if (promptForDelete().get() == ButtonType.OK) {
                                            deleteUser(user);
                                            RootView.instance.setCenter(AllUsersListView.getInstance());
                                        }
                                    });
                                    break;
                            }
                            setGraphic(link);

                        }
                    }
                };
            }
        };
    }

    private static void promoteUser(User user) {
        String promoteQuery = "UPDATE RateACity.USER\n" +
                "SET isManager=1, isSuspended=0\n" +
                "WHERE email=\'" + user.getEmail() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(promoteQuery);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static void demoteUser(User user) {
        String demoteQuery = "UPDATE RateACity.USER\n" +
                "SET isManager=0\n" +
                "WHERE email=\'" + user.getEmail() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(demoteQuery);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static void removeSuspension(User user) {
        String removeSuspensionQuery = "UPDATE RateACity.USER\n" +
                "SET isSuspended=0\n" +
                "WHERE email=\'" + user.getEmail() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(removeSuspensionQuery);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static void suspend(User user) {
        String suspendQuery = "UPDATE RateACity.USER\n" +
                "SET isSuspended=1\n" +
                "WHERE email=\'" + user.getEmail() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(suspendQuery);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static void deleteUser(User user) {
        String deleteUserQuery = "DELETE FROM RateACity.USER\n" +
                "WHERE email=\'" + user.getEmail() + "\';";
        try {
            DBConnection.connection.createStatement().executeUpdate(deleteUserQuery);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static Optional<ButtonType> promptForPromote() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Promote Account");
        alert.setHeaderText("Are You Sure You Want to Promote?");
        alert.setContentText("The user will be promoted to site manager and be "
                + "able to promote others, delete accounts, and approve pending "
                + " cities and locations");
        return alert.showAndWait();
    }

    private static Optional<ButtonType> promptForDemote() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Demote Account");
        alert.setHeaderText("Are You Sure You Want to Demote?");
        alert.setContentText("The user will be demoted to a regular user");
        return alert.showAndWait();
    }

    private static Optional<ButtonType> promptForSuspension() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Suspend Account");
        alert.setHeaderText("Are You Sure You Want to Suspend?");
        alert.setContentText("The user will be unable to post any further comments or submit cities and attractions.");
        return alert.showAndWait();
    }

    private static Optional<ButtonType> promptForSuspensionRemoval() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Suspension Removal");
        alert.setHeaderText("Are You Sure You Want to Remove Suspension?");
        alert.setContentText("The user will be able to post reviews and submit cities and attractions for review.");
        return alert.showAndWait();
    }

    private static Optional<ButtonType> promptForDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete Account");
        alert.setHeaderText("Are You Sure You Want to Delete?");
        alert.setContentText("This will remove all comments and ratings associated "
                + " with this user.");
        return alert.showAndWait();
    }

    private static boolean onlyOneManager() {
        String managerCountQuery = "SELECT COUNT(*) FROM RateACity.User\n" +
                "WHERE isManager=1";
        try {
            ResultSet rs = DBConnection.connection.createStatement().executeQuery(managerCountQuery);
            if (rs.next()) {
                return rs.getString("COUNT(*)").equals("1");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void displayManagerError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Unable to Perform That Action");
        alert.setContentText("There must be at least one manager in the database.");
        alert.showAndWait();
    }
}
