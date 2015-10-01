package com.example.wojciech.partytime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech on 2015-09-26.
 */
public class Items {
    final static String[] sizes = {"Large","Small"};
    private int size;
    private long id;
    private DetailsOfRestaurant menu[];
    private String name;

    public Items(List<Restaurants> restaurants, int i) throws JSONException{
        size = restaurants.get(i).getAmountDishes();
        id = restaurants.get(i).getID();
        name = restaurants.get(i).getRestaurantName();
        menu = new DetailsOfRestaurant[size];
        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList<String> tastes = new ArrayList<>();
        ArrayList<String> sizes = new ArrayList<>();

        int priceIterator = 1;
        int tasteIterator = 1;
        int sizeIterator = 0;

        for(int j = 0;j < size;++j) {
            while(true) {
                try {
                    doubles.add(restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getJSONObject("Price").getDouble("Price" + priceIterator++));
                }catch(JSONException e){
                    priceIterator = 1;
                    e.printStackTrace();
                    break;
                }
            }
            while(true) {
                try {
                    tastes.add(restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getJSONObject("Taste").getString("Taste" + tasteIterator++));
                }catch(JSONException e){
                    tasteIterator = 1;
                    e.printStackTrace();
                    break;
                }
            }
            for(int k = 0;k < 2;++k){
                try {
                    sizes.add(restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getJSONObject("Size").getString(this.sizes[sizeIterator++]));
                }catch(JSONException e){
                    e.printStackTrace();
                    continue;
                }
            }
            sizeIterator = 0;

            URL url;
            Bitmap bmp = null;
            try {
                url = new URL((String) restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getJSONObject("Photo").get("url"));
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException | JSONException e1) {
                e1.printStackTrace();
            }

            Double[] prices = new Double[doubles.size()];
            doubles.toArray(prices);

            String[] tastesArr = new String[tastes.size()];
            tastes.toArray(tastesArr);

            String[] sizeArr = new String[sizes.size()];
            sizes.toArray(sizeArr);
            if(bmp == null){
                System.out.println("Obrazek sie nie wczytal");
            }
            menu[j] = new DetailsOfRestaurant(restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getString("Title"),
                    restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getString("Describe"),
                    restaurants.get(i).getDetailsOfRestaurant().getJSONObject(j).getLong("Time"),
                    prices, sizeArr, tastesArr, bmp);

            doubles.clear();
            sizes.clear();
            tastes.clear();
        }


        }

    public static String[] getSizes() {
        return sizes;
    }

    public int getSize() {
        return size;
    }

    public long getId() {
        return id;
    }

    public DetailsOfRestaurant[] getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }
}

