package main.java.model;

import javafx.scene.control.Hyperlink;

/**
 * Created by benge on 7/21/2017.
 */
public class Attraction {
    private String attraction;
    private String category;
    private String city;
    private String aveRating;
    private String numRatings;

    public Attraction(String attraction, String category, String city, String aveRating, String numRatings) {
        this.attraction = attraction;
        this.category = category;
        this.city = city;
        this.aveRating = aveRating;
        this.numRatings = numRatings;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAveRating() {
        return aveRating;
    }

    public void setAveRating(String aveRating) {
        this.aveRating = aveRating;
    }

    public String getNumRatings() { return numRatings; }

    public void setNumRatings(String numRatings) { this.numRatings = numRatings; }

}
