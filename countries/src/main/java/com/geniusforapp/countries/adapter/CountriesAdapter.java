package com.geniusforapp.countries.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geniusforapp.countries.R;
import com.geniusforapp.countries.adapter.holders.CountriesViewHolder;
import com.geniusforapp.countries.entites.EntityCountry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * Created by ahmadnajar on 3/9/17.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder> {


    private ArrayList<EntityCountry> countries = new ArrayList<>();
    private ArrayList<EntityCountry> copyCountries = new ArrayList<>();
    OnCountryClickListener onCountryClickListener;
    private Activity activity;

    public CountriesAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setOnCountryClickListener(OnCountryClickListener onCountryClickListener) {
        this.onCountryClickListener = onCountryClickListener;
    }


    @Override
    public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CountriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_country, null));
    }

    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        final EntityCountry country = countries.get(position);
        holder.countryEn.setText(country.getName() + " - " + country.getNativeName());
        holder.region.setText(country.getRegion());
        holder.timezone.setText(country.getTimezones() != null ? (!country.getTimezones().isEmpty() ? country.getTimezones().get(0) : "") : "");
        holder.dialingCode.setText(country.getCallingCodes() != null ? (!country.getCallingCodes().isEmpty() ? "(+" + country.getCallingCodes().get(0) + ")" : "") : "");
        holder.cardCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCountryClickListener != null) {
                    onCountryClickListener.OnCountryClick(country);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public void addAll(Collection<EntityCountry> newList) {
        countries.clear();
        countries.addAll(newList);
        copyCountries.clear();
        copyCountries.addAll(newList);
        notifyDataSetChanged();
    }

    public void filter(String newText) {
        countries.clear();
        if (!newText.toLowerCase().isEmpty()) {
            for (EntityCountry country : copyCountries) {
                if (Pattern.compile(Pattern.quote(newText.toLowerCase()), Pattern.CASE_INSENSITIVE).matcher(country.getNativeName().toLowerCase()).find()
                        || Pattern.compile(Pattern.quote(newText.toLowerCase()), Pattern.CASE_INSENSITIVE).matcher(country.getName().toLowerCase()).find()
                        || Pattern.compile(Pattern.quote(newText.toLowerCase()), Pattern.CASE_INSENSITIVE).matcher(country.getCallingCodes().get(0).toLowerCase()).find()) {
                    countries.add(country);
                }
            }
        } else {
            countries.addAll(copyCountries);
        }

        notifyDataSetChanged();
    }

    public interface OnCountryClickListener {
        void OnCountryClick(EntityCountry country);
    }

}
