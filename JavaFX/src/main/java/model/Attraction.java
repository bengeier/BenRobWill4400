package main.java.model;

/**
 * Created by benge on 7/21/2017.
 */
public class Attraction {
    private String attraction;
    private String category;
    private String city;
    private String aveRating;
    private String numRatings;

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

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
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
