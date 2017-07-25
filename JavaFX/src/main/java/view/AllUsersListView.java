package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import main.java.controller.AllCitiesListController;
import main.java.controller.AllUsersListController;
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

    private void updateTable() {
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        dateJoinedCol.setCellValueFactory(
                new PropertyValueFactory<>("dateJoined"));
        suspendedCol.setCellValueFactory(
                new PropertyValueFactory<>("suspended"));
        userClassCol.setCellValueFactory(
                new PropertyValueFactory<>("userClass"));
        deleteCol.setCellValueFactory(
                new PropertyValueFactory<>("delete"));

        usersTable.setItems(AllUsersListController.buildData());

        userClassCol.setCellFactory(AllUsersListController.generateCellFactory("userClass"));
        suspendedCol.setCellFactory(AllUsersListController.generateCellFactory("suspended"));
        deleteCol.setCellFactory(AllUsersListController.generateCellFactory("delete"));
    }
}
