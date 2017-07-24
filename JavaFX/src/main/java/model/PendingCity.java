package main.java.model;

/**
 * Created by Michael Xiao Local on 7/23/2017.
 */
public class PendingCity {
    private String cityEID;
    private String cityName;
    private String country;
    private String submittedBy;
    private String rating;
    private String comment;

    public PendingCity(String cityEID, String cityName) {
        this(cityEID, cityName, null, null, null, null);
    }

    public PendingCity(String cityEID, String cityName, String country, String submittedBy, String rating, String comment) {
        this.cityEID = cityEID;
        this.cityName = cityName;
        this.country = country;
        this.submittedBy = submittedBy;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return cityName;
    }

    public String getCityEID() {
        return cityEID;
    }

    public void setCityEID(String city) {
        this.cityEID = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
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

