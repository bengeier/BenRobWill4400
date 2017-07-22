package main.java.model;

/**
 * Created by Rob on 7/21/2017.
 */
public class City {
    private String cityEID;
    private String cityName;
    private String avgRating;
    private String numRatings;
    private String numAttractions;

    public City(String cityEID, String cityName) {
        this(cityEID, cityName, null, null, null);
    }

    public City(String cityEID, String cityName, String avgRating, String numRatings, String numAttractions) {
        this.cityEID = cityEID;
        this.cityName = cityName;
        this.avgRating = avgRating;
        this.numRatings = numRatings;
        this.numAttractions = numAttractions;
    }

    @Override
    public String toString() {
        return cityEID + " " + cityName;
    }

    public String getCityEID() {
        return cityEID;
    }

    public void setCityEID(String city) {
        this.cityEID = city;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
