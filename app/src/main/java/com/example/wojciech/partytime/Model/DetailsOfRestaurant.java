package com.example.wojciech.partytime.Model;


import android.graphics.Bitmap;

/**
 * Created by Wojciech on 2015-09-21.
 */
public class DetailsOfRestaurant  {
    private String title;
    private String describe;
    private long time;
    private Double[] price;
    private String[] size;
    private String[] taste;
    private Bitmap photo = null;

    public DetailsOfRestaurant(String title, String describe, long time, Double[] price, String[] size, String[] taste, Bitmap photo) {
        this.title = title;
        this.describe = describe;
        this.time = time;
        this.price = price;
        this.size = size;
        this.taste = taste;
        this.photo = Bitmap.createBitmap(photo);
    }

    public String getTitle() {
        return title;
    }

    public String getDescribe() {
        return describe;
    }

    public long getTime() {
        return time;
    }

    public Double[] getPrice() {
        return price;
    }

    public String[] getSize() {
        return size;
    }

    public String[] getTaste() {
        return taste;
    }

    public Bitmap getPhoto() {
        return photo;
    }
}
