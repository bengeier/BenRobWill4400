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

    private static Stack<String> lastVisited = new Stack<>();

    public static String pop() {
        return lastVisited.pop();
    }

    public static void push(String x) {
        lastVisited.push(x);
    }
}
