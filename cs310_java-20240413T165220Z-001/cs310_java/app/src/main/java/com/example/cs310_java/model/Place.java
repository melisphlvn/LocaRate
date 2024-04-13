package com.example.cs310_java.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Place implements Serializable {
    private String name;
    private String type;
    private double rating;

    public Place(String name, String type, double rating) {
        this.name = name;
        this.type = type;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getRating() {
        return rating;
    }

}
