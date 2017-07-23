package main.java.model;

/**
 * Created by Michael Xiao Local on 7/23/2017.
 */
public class User {
    private String email;
    private String dateJoined;
    private String userClass;
    private String suspended;

    public User(String email) {
        this(email, null, null, null);
    }

    public User(String email, String dateJoined, String userClass, String suspended) {
        this.email = email;
        this.dateJoined = dateJoined;
        this.userClass = userClass;
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }

}
