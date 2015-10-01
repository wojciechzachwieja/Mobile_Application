package com.example.wojciech.partytime;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;


/**
 * Created by Wojciech on 2015-09-19.
 */
@ParseClassName("Restaurants")
public class Restaurants extends ParseObject{
    public Long getID() {
        return getLong("ID");
    }
    public void setID(Long value) {
        put("ID", value);
    }
    public String getRestaurantName() {
        return getString("RestaurantName");
    }
    public void setRestaurantName(String value) {
        put("RestaurantName", value);
    }
    public JSONArray getDetailsOfRestaurant() {
        return getJSONArray("DetailsOfRestaurant");
    }
    public void setDetailsOfRestaurant(JSONArray value) {
        put("DetailsOfRestaurant", value);
    }
    public Integer getAmountDishes() {
        return getInt("AmountDishes");
    }
    public void setAmountDishes(Integer value) {
        put("AmountDishes", value);
    }

    public Restaurants() {
    }
}
