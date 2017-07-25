package main.java.model;

import java.util.Stack;

public class CurrentState {

    private static String email = "";
    private static City currentCity;
    private static String currentCategory = "";
    private static Review currentReview;
    private static Attraction currentAttraction;
    private static boolean managerView = false;
    private static boolean suspended = false;
    private static boolean isAttractionSearch = false;
    private static String attractionSearchParam = "";

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

    public static boolean isSuspended() {
        return suspended;
    }

    public static void setSuspended(boolean suspended) {
        CurrentState.suspended = suspended;
    }

    public static boolean isAttractionSearch() {
        return isAttractionSearch;
    }

    public static void setIsAttractionSearch(boolean isAttractionSearch) {
        CurrentState.isAttractionSearch = isAttractionSearch;
    }

    public static String getAttractionSearchParam() {
        return attractionSearchParam;
    }

    public static void setAttractionSearchParam(String attractionSearchParam) {
        CurrentState.attractionSearchParam = attractionSearchParam;
    }

    public static Review getCurrentReview() {
        return currentReview;
    }

    public static void setCurrentReview(Review currentReview) {
        CurrentState.currentReview = currentReview;
    }
}
