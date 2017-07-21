package main.java.model;

import javafx.scene.layout.BorderPane;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by wepperson on 7/21/17.
 */
public class CurrentState {

    private static String email = "";

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String e) {
        email = e;
    }

    private static Stack<BorderPane> lastVisited;

    public static BorderPane pop() {
        return lastVisited.pop();
    }

    public static void push(BorderPane x) {
        lastVisited.push(x);
    }
}
