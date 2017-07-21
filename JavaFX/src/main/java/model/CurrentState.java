package main.java.model;

import javafx.scene.layout.BorderPane;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by wepperson on 7/21/17.
 */
public class CurrentState {

    private static String email = "";
    private static String currentCity = "";
    private static String currentCategory = "";

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

    public static String getCurrentCity() {
        return currentCity;
    }

    public static void setCurrentCity(String currentCity) {
        CurrentState.currentCity = currentCity;
    }

    public static String getCurrentCategory() {
        return currentCategory;
    }

    public static void setCurrentCategory(String currentCategory) {
        CurrentState.currentCategory = currentCategory;
    }
}
