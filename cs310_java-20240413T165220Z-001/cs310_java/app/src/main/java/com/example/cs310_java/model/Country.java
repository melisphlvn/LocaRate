package com.example.cs310_java.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {
    private String name;
    private String capital;
    private String region;
    private String currency;
    private String languages;
    private ArrayList<Place> places;
    private int imageid;

    public Country(String name, String capital, String region, String currency, String languages, ArrayList<Place> places, int imageid) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.currency = currency;
        this.languages = languages;
        this.places = places;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLanguages() {
        return languages;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public int getImageid() {
        return imageid;
    }
}

