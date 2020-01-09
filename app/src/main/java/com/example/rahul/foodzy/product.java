package com.example.rahul.foodzy;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rahul on 14-10-2017.
 */

public class product implements Serializable{
    private int id;
    private String name;
    private  String description;
    private  String size;
    private String qty;
    private String price;
    private Integer image;


    public product( String name, String qty, String price,Integer image) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.description="";
        this.size="";
        this.image=image;
    }

    public product( String name, String description, String size, String qty, String price, Integer image) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.qty = qty;
        this.price=price;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
