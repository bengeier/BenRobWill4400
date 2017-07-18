package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

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
            RootView.instance.setCenter(ManagerView.instance);
        }));

        addUser.setOnAction((event -> {
            RootView.instance.setCenter(SignUpView.instance);
        }));
    }
}
