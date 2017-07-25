package main.java.model;

import java.util.ArrayList;

/**
 * Created by Michael Xiao Local on 7/24/2017.
 */
public class PendingAttraction {
    private String attractionEID;
    private String attractionName;
    private String city;
    private String address;
    private String country;
    private String category;
    private String description;
    private String hours;
    private String contactInfo;
    private String submittedBy;
    private String rating;
    private String comment;

    private ArrayList<String> categoryList = new ArrayList<>();

    public PendingAttraction(String attractionEID) {
        this(attractionEID,
                null, null, null, null, null, null, null, null, null, null, null);
    }

    public PendingAttraction(
            String attractionEID,
            String attractionName,
            String city,
            String address,
            String country,
            String category,
            String description,
            String hours,
            String contactInfo,
            String submittedBy,
            String rating,
            String comment) {
        this.attractionEID = attractionEID;
        this.attractionName = attractionName;
        this.city = city;
        this.address = address;
        this.country = country;
        this.category = category;
        this.description = description;
        this.hours = hours;
        this.contactInfo = contactInfo;
        this.submittedBy = submittedBy;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return attractionName + ", " + city + ", " + country;
    }

    public String getAttractionEID() {
        return attractionEID;
    }

    public void setAttractionEID(String attractionEID) {
        this.attractionEID = attractionEID;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {if (categoryList.isEmpty()) {
        return null;
    }

        if (categoryList.size() == 1) {
            return categoryList.get(0);
        }

        String x = "";
        for (int i = 0; i < categoryList.size(); i++) {
            if (i < categoryList.size() - 1) {
                x += categoryList.get(i) + ", ";
            } else {
                x += categoryList.get(i);
            }
        }

        return x;
    }

    public void addCategory(String category) {

        categoryList.add(category);
    }
    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
