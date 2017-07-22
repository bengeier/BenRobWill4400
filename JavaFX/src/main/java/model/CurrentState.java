package main.java.model;

import javafx.scene.layout.BorderPane;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by wepperson on 7/21/17.
 */
public class CurrentState {

    private static String email = "";
    private static City currentCity;
    private static String currentCategory = "";
    private static String currentAttraction = "";

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

    public static City getCurrentCity() {
        return currentCity;
    }

    public static void setCurrentCity(City currentCity) {
        CurrentState.currentCity = currentCity;
    }

    public static String getCurrentCategory() {
        return currentCategory;
    }

    public static void setCurrentCategory(String currentCategory) {
        CurrentState.currentCategory = currentCategory;
    }

    public static String getCurrentAttraction() { return currentAttraction; }

    public static void setCurrentAttraction(String currentAttraction) {CurrentState.currentAttraction = currentAttraction; }
}
