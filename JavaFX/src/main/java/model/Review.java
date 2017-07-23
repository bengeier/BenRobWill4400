package main.java.model;

/**
 * Created by wepperson on 7/23/17.
 */
public class Review {

    private String userEmail, rating, comment;

    public Review(String userEmail, String rating, String comment) {
        this.userEmail = userEmail;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
