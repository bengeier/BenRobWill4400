package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.controller.UserController;
import main.java.model.City;
import main.java.model.CurrentState;
import main.java.model.User;

/**
 * Created by wepperson on 7/18/17.
 */
public class AllUsersListView {

    private static String fxml = "AllUsersList.fxml";
    private static BorderPane instance;

    public static BorderPane getInstance() {
        instance = (BorderPane) FXBuilder.getFXMLView(fxml);
        return instance;
    }

    @FXML
    Button addUser, back;

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, String> emailCol, dateJoinedCol, userClassCol, suspendedCol, deleteCol;

    @FXML
    public void initialize() {
        //Calls method to query database and update table
        updateTable();

        back.setOnAction((event -> {
            RootView.instance.setCenter(FXBuilder.getFXMLView(CurrentState.pop()));
        }));

        addUser.setOnAction((event -> {
            CurrentState.push(fxml);
            RootView.instance.setCenter(SignUpView.getInstance());
        }));
    }

    private void promptForPromote() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Promote Account");
        alert.setHeaderText("Are You Sure You Want to Promote?");
        alert.setContentText("The user will be promoted to site manager and be "
                + "able to promote others, delete accounts, and approve pending "
                + " cities and locations");
        alert.showAndWait();
    }

    private void promptForSuspend() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Suspend Account");
        alert.setHeaderText("Are You Sure You Want to Suspend?");
        alert.setContentText("The user will be unable to post any further comments.");
        alert.showAndWait();
    }

    private void promptForDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete Account");
        alert.setHeaderText("Are You Sure You Want to Delete?");
        alert.setContentText("This will remove all comments and ratings associated "
            + " with this user.");
        alert.showAndWait();
    }

    private void updateTable() {
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        dateJoinedCol.setCellValueFactory(
                new PropertyValueFactory<>("dateJoined"));
        userClassCol.setCellValueFactory(
                new PropertyValueFactory<>("userClass"));
        suspendedCol.setCellValueFactory(
                new PropertyValueFactory<>("suspended"));
        deleteCol.setCellValueFactory(
                new PropertyValueFactory<>("delete"));


        /*
            Unfortunately this code works. You could probably refactor it idk
        */
        //link.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        /*Callback<TableColumn<City, String>, TableCell<City, String>> cellFactory
                = new Callback<TableColumn<City, String>, TableCell<City, String>>() {
            @Override
            public TableCell<City, String> call(TableColumn<City, String> param) {
                return new TableCell<City, String>() {
                    final Hyperlink pageLink =
                            new Hyperlink(suspendedCol.getCellObservableValue("suspended").getValue());

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pageLink.setOnAction(event -> {
                                City city = getTableView().getItems().get(getIndex());
                                CurrentState.setCurrentCity(city);
                                CurrentState.push(fxml);
                                RootView.instance.setCenter(CityView.getInstance());
                            });
                            setGraphic(pageLink);
                            setText(null);
                        }
                    }
                };
            }
        };
        link.setCellFactory(cellFactory);*/
        usersTable.setItems(UserController.buildData());
    }
}
