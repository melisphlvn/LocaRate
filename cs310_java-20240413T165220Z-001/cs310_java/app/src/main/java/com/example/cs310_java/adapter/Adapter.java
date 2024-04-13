package com.example.cs310_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs310_java.databinding.RecyclerRowBinding;
import com.example.cs310_java.model.Country;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private ArrayList<Country> countryList;
    private OnCountryClickListener onCountryClickListener;

    public interface OnCountryClickListener {
        void onCountryClick(Country country);
    }

    public Adapter(ArrayList<Country> countryList, OnCountryClickListener listener) {
        this.countryList = countryList;
        this.onCountryClickListener = listener;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public Holder(RecyclerRowBinding binding, OnCountryClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(view -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    Country clickedCountry = (Country) itemView.getTag();
                    listener.onCountryClick(clickedCountry);
                }
            });
        }

        public void bind(Country country) {
            binding.countryText.setText(country.getName());
            itemView.setTag(country);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Holder(binding, onCountryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, int position) {
        Country country = countryList.get(position);
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

}
