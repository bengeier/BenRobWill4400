package main.java.model;

/**
 * Created by benge on 7/21/2017.
 */
public class Attraction {
    private String attractionEID;
    private String attractionName;
    private String category;
    private String city;
    private String aveRating;
    private String numRatings;

    public Attraction(String attractionEID, String attractionName, String category, String city, String aveRating, String numRatings) {
        this.attractionEID = attractionEID;
        this.attractionName = attractionName;
        this.category = category;
        this.city = city;
        this.aveRating = aveRating;
        this.numRatings = numRatings;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
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

    public String getAttractionEID() {
        return attractionEID;
    }

    public void setAttractionEID(String attractionEID) {
        this.attractionEID = attractionEID;
    }
}
