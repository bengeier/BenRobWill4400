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
    private String address;
    private String description;
    private String hours;
    private String contact;

    public Attraction(String attractionEID, String attractionName, String category, String description,
                      String hours, String address, String city, String aveRating, String numRatings, String contact) {
        this.attractionEID = attractionEID;
        this.attractionName = attractionName;
        this.description = description;
        this.hours = hours;
        this.category = category;
        this.address = address;
        this.city = city;
        this.aveRating = aveRating;
        this.numRatings = numRatings;
        this.contact = contact;
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

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getHours() { return hours; }

    public void setHours(String hours) { this.hours = hours; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }
}
