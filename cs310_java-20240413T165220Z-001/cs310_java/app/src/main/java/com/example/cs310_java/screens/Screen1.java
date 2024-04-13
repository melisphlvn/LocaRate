package com.example.cs310_java.screens;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs310_java.R;
import com.example.cs310_java.adapter.Adapter;
import com.example.cs310_java.databinding.FragmentScreen1Binding;
import com.example.cs310_java.model.Country;
import com.example.cs310_java.viewmodel.SharedViewModel;

import java.util.ArrayList;

public class Screen1 extends Fragment {
    private FragmentScreen1Binding binding;
    private Adapter countryAdapter;
    private SharedViewModel viewModel;

    public Screen1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScreen1Binding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Country> countryList = viewModel.getCountryList();

        //countryList = (ArrayList<Country>) getArguments().getSerializable("countryList");
        //countryList = (ArrayList<Country>) getActivity().getIntent().getSerializableExtra("countryList");

        if (countryList != null) {
            countryAdapter = new Adapter(countryList, country -> {
                viewModel.setSelectedCountry(country);
                navigateToScreen2();
            });

            binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            binding.recyclerView.setAdapter(countryAdapter);
        }

    }

    private void navigateToScreen2() {
        Screen2 fragment2 = new Screen2();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2).addToBackStack(null).commit();
    }
}
