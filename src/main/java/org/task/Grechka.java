package org.task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class Grechka {
    String name, price, img, link, country, weight;
    HashMap<String, String> map = new HashMap<>();


    public Grechka(JSONObject object) throws JSONException {
        name = (String) object.get("name");

        price = (String) object.get("price");

        img = (String) object.get("img");
        link = (String) object.get("link");
        country = (String) object.get("country");
        weight = (String) object.get("weight");
    }

    public  HashMap<String,String> getAll(){
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
