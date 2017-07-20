package main.java.model;

/**
 * Created by wepperson on 7/21/17.
 */
public class CurrentUser {

    private static String email = "";

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String e) {
        email = e;
    }
}
