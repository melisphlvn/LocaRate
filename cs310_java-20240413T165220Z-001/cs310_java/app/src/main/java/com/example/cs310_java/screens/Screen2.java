package com.example.cs310_java.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs310_java.R;
import com.example.cs310_java.databinding.FragmentScreen2Binding;
import com.example.cs310_java.model.Country;
import com.example.cs310_java.model.Place;
import com.example.cs310_java.viewmodel.SharedViewModel;

import java.util.List;

public class Screen2 extends Fragment {
    private FragmentScreen2Binding binding;
    private SharedViewModel viewModel;

    public Screen2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScreen2Binding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding.backButton.setOnClickListener(v -> goBack());
        return binding.getRoot();
    }

    private void goBack() {
        if (requireActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
            requireActivity().onBackPressed();
        } else {
            requireActivity().finish();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Country country = viewModel.getSelectedCountry();

        if (country != null) {
            binding.nameText.setText("Country: " + country.getName());
            binding.currencyText.setText("Currency: " + country.getCurrency());
            binding.languageText.setText("Languages: " + country.getLanguages());
            binding.regionText.setText("Region: " + country.getRegion());
            binding.capitalText.setText("Capital: " + country.getCapital());
            binding.countryImage.setImageResource(country.getImageid());

            displayClickablePlaces(country.getPlaces());
        }
    }

    private void displayClickablePlaces(List<Place> places) {
        SpannableStringBuilder clickableText = new SpannableStringBuilder();
        for (int i = 0; i < places.size(); i++) {
            Place place = places.get(i);
            String placeName = place.getName();
            String placeDetails = "Place Name: " + placeName + "\nType: " + place.getType() + "\nRating: " + place.getRating() + "\n\n";

            int start = clickableText.length() + "Place Name: ".length();
            int end = start + placeName.length();
            clickableText.append(placeDetails);


            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    viewModel.setPlace(place);
                    navigateToScreen3();
                }
            };
            clickableText.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        binding.placeText.setMovementMethod(LinkMovementMethod.getInstance());
        binding.placeText.setText(clickableText);
    }

    private void navigateToScreen3() {
        Screen3 fragment3 = new Screen3();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment3).addToBackStack(null).commit();
    }
}