package main.java.model;

import javafx.scene.layout.BorderPane;

import java.util.Queue;
import java.util.Stack;

public class CurrentState {

    private static String email = "";
    private static City currentCity;
    private static String currentCategory = "";
    private static Attraction currentAttraction;
    private static boolean managerView = false;

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

    public static String peek() { return lastVisited.peek(); }

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

    public static Attraction getCurrentAttraction() {
        return currentAttraction;
    }

    public static void setCurrentAttraction(Attraction currentAttraction) {
        CurrentState.currentAttraction = currentAttraction;
    }

    public static boolean isManagerView() {
        return managerView;
    }

    public static void setManagerView(boolean managerView) {
        CurrentState.managerView = managerView;
    }
}
