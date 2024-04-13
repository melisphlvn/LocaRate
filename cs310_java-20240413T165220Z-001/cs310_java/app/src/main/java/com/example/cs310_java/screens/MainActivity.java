package com.example.cs310_java.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import android.os.Bundle;

import com.example.cs310_java.R;
import com.example.cs310_java.databinding.ActivityMainBinding;
import com.example.cs310_java.model.Country;
import com.example.cs310_java.model.Place;
import com.example.cs310_java.viewmodel.SharedViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Country> countryList;
    private NavController navigationController;
    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        countryList = new ArrayList<>();

        Place place1 = new Place("C’e Pasta...e Pasta", "restaurant", 3.5);
        Place place2 = new Place("Picasso Museum", "museum", 2.5);
        Place place3 = new Place("Louvre Museum", "museum", 4.1);
        Place place4 = new Place("Hotel NH Berlin", "hotel", 2.5);
        Place place5 = new Place("Hide", "restaurant", 4.5);
        Place place6 = new Place("Tower of London", "landmark", 3.9);
        Place place7 = new Place("Bless", "restaurant", 4.7);
        Place place8 = new Place("Trevi Fountain", "landmark", 4.9);
        Place place9 = new Place("Cafe de Paris", "restaurant", 2.7);
        Place place10 = new Place("Catalonia Park Putxet", "hotel", 3.7);
        Place place11 = new Place("Radisson Blu Plaza Delhi Airport", "Hotel", 4.2);
        Place place12 = new Place("Udaipur City Palace", "Museum", 3.8);
        Place place13 = new Place("Pinacoteca do Estado de São Paulo", "Museum", 3.6);
        Place place14 = new Place("Statue of Christ the Redeemer", "Landmark", 4.7);
        Place place15 = new Place("Mr. Shi's Dumplings", "restaurant", 4.3);
        Place place16 = new Place("Hong Kong Skyline", "landmark", 4.8);
        Place place17 = new Place("Fairmont Château Lake Louise", "hotel", 4.6);
        Place place18 = new Place("The CN Tower", "landmark", 4.3);
        Place place19 = new Place("Aman Tokyo", "hotel", 3.9);
        Place place20 = new Place("Izakaya", "restaurant", 3.5);


        Country country1 = new Country("Italy", "Rome", "Europe", "Euro", "Italian", new ArrayList<>(Arrays.asList(place1, place2, place8)), R.drawable.italy);
        Country country2 = new Country("Spain", "Madrid", "Europe", "Euro", "Spanish", new ArrayList<>(Arrays.asList(place10)), R.drawable.spain);
        Country country3 = new Country("France", "Paris", "Europe", "Euro", "French", new ArrayList<>(Arrays.asList(place3, place9)), R.drawable.france);
        Country country4 = new Country("Germany", "Berlin", "Europe", "Euro", "German", new ArrayList<>(Arrays.asList(place4, place7)), R.drawable.germany);
        Country country5 = new Country("United Kingdom", "London", "Europe", "Pound Sterling", "English", new ArrayList<>(Arrays.asList(place5, place6)), R.drawable.uk);
        Country country6 = new Country("Japan", "Tokyo", "Asia", "Yen", "Japanese", new ArrayList<>(Arrays.asList(place19, place20)), R.drawable.japan);
        Country country7 = new Country("China", "Beijing", "Asia", "Yuan", "Chinese", new ArrayList<>(Arrays.asList(place15, place16)), R.drawable.china);
        Country country8 = new Country("Brazil", "Brasília", "South America", "Real", "Portuguese", new ArrayList<>(Arrays.asList(place13, place14)), R.drawable.brazil);
        Country country9 = new Country("Canada", "Ottawa", "North America", "Canadian Dollar", "English, French", new ArrayList<>(Arrays.asList(place17, place18)), R.drawable.canada);
        Country country10 = new Country("India", "New Delhi", "Asia", "Indian Rupee", "Hindi, English", new ArrayList<>(Arrays.asList(place11, place12)), R.drawable.india);

        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
        countryList.add(country5);
        countryList.add(country6);
        countryList.add(country7);
        countryList.add(country8);
        countryList.add(country9);
        countryList.add(country10);

        viewModel.setCountryList(countryList);

        /*Screen1 fragment1 = new Screen1();
        Bundle bundle = new Bundle();
        bundle.putSerializable("countryList", countryList);
        fragment1.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment1)
                .addToBackStack(null)
                .commit();*/
    }
}