package main.java.model;

/**
 * Created by wepperson on 7/23/17.
 */
public class Review {

    private String userEmail, rating, comment, reviewableEID, entityName;

    public Review(String userEmail, String reviewableEID) {
        this(userEmail, null, null, reviewableEID, null);
    }

    public Review(String userEmail, String rating, String comment, String reviewableEID, String entityName) {
        this.userEmail = userEmail;
        this.rating = rating;
        this.comment = comment;
        this.reviewableEID = reviewableEID;
        this.entityName = entityName;
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

    public String getReviewableEID() {
        return reviewableEID;
    }

    public void setReviewableEID(String reviewableEID) {
        this.reviewableEID = reviewableEID;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
