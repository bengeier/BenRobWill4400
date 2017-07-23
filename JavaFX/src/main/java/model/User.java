package main.java.model;

/**
 * Created by Michael Xiao Local on 7/23/2017.
 */
public class User {
    private String email;
    private String dateJoined;
    private String userClass;
    private String suspended;
    private String delete;

    public User(String email) {
        this(email, null, null, null, null);
    }

    public User(String email, String dateJoined, String userClass, String suspended, String delete) {
        this.email = email;
        this.dateJoined = dateJoined;
        this.userClass = userClass;
        this.suspended = suspended;
        this.delete = delete;
    }

    @Override
    public String toString() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String city) {
        this.email = email;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String avgRating) {
        this.dateJoined = dateJoined;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String numRatings) {
        this.userClass = userClass;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setSuspended(String numAttractions) {
        this.suspended = suspended;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String cityName) {
        this.delete = delete;
    }
}
