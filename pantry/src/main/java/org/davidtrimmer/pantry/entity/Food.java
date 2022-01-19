package org.davidtrimmer.pantry.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Food implements Serializable{

    private String foodId ;
    private String uri ;
    private String label ;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> nutrients ;
    private String category ;
    private String categoryLabel;
    private String image ;

    public Food() {
    }

    public Food(String foodId, String uri, String label, List<String> nutrients, String category, String categoryLabel, String image) {
        this.foodId = foodId;
        this.uri = uri;
        this.label = label;
        this.nutrients = nutrients;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.image = image;
    }
    @JsonProperty("foodId")
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @JsonProperty("nutrients")
    public List<String> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<String> nutrients) {
        this.nutrients = nutrients;
    }
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @JsonProperty("categoryLabel")
    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return Objects.equals(foodId, food.foodId) && Objects.equals(uri, food.uri) && Objects.equals(label, food.label) && Objects.equals(nutrients, food.nutrients) && Objects.equals(category, food.category) && Objects.equals(categoryLabel, food.categoryLabel) && Objects.equals(image, food.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId, uri, label, nutrients, category, categoryLabel, image);
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId='" + foodId + '\'' +
                ", uri='" + uri + '\'' +
                ", label='" + label + '\'' +
                ", nutrients=" + nutrients +
                ", category='" + category + '\'' +
                ", categoryLabel='" + categoryLabel + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}