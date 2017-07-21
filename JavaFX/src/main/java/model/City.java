package main.java.model;

import javafx.scene.control.Hyperlink;

/**
 * Created by Rob on 7/21/2017.
 */
public class City {
    private String city;
    private String avgRating;
    private String numRatings;
    private String numAttractions;
    private Hyperlink link;


    public City (String city, String avgRating, String numRatings, String numAttractions, Hyperlink link) {
        this.city = city;
        this.avgRating = avgRating;
        this.numRatings = numRatings;
        this.numAttractions = numAttractions;
        this.link = link;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }

    public String getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(String numRatings) {
        this.numRatings = numRatings;
    }

    public String getNumAttractions() {
        return numAttractions;
    }

    public void setNumAttractions(String numAttractions) {
        this.numAttractions = numAttractions;
    }

    public Hyperlink getLink() {
        return link;
    }

    public void setLink(Hyperlink link) {
        this.link = link;
    }
}
