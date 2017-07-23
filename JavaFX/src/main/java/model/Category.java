package main.java.model;

/**
 * Created by Michael Xiao Local on 7/23/2017.
 */
public class Category {

    private String categoryName;
    private String numAttractions;

    public Category(String categoryName) {
        this(categoryName, null);
    }

    public Category(String categoryName, String numAttractions) {
        this.categoryName = categoryName;
        this.numAttractions = numAttractions;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCityName(String cityName) {
        this.categoryName = cityName;
    }

    public String getNumAttractions() {
        return numAttractions;
    }

    public void setNumAttractions(String numAttractions) {
        this.numAttractions = numAttractions;
    }



}
