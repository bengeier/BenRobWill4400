package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.java.model.CurrentState;

/**
 * Created by wepperson on 7/18/17.
 */
public class AllUsersListView {
    public static BorderPane instance = (BorderPane) FXBuilder.getFXMLView("AllUsersList.fxml");

    @FXML
    Button addUser, back;

    @FXML
    public void initialize() {
        back.setOnAction((event -> {
            RootView.instance.setCenter(CurrentState.pop());
            CurrentState.push(this.instance);
        }));

        addUser.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
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
}
