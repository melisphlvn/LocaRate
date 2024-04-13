package com.example.cs310_java.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.cs310_java.model.Country;
import com.example.cs310_java.model.Place;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private ArrayList<Country> countryList;
    private Country selectedCountry;
    private Place selectedPlace;

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(ArrayList<Country> countryList) {
        this.countryList = countryList;
    }

    public void setSelectedCountry(Country country) {
        this.selectedCountry = country;
    }

    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public void setPlace(Place place) {
        this.selectedPlace = place;
    }

    public Place getPlace() {
        return selectedPlace;
    }

    ;
}
