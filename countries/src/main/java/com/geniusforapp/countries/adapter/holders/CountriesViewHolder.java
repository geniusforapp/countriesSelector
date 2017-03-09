package com.geniusforapp.countries.adapter.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geniusforapp.countries.R;

/**
 * Created by ahmadnajar on 3/9/17.
 */

public class CountriesViewHolder extends RecyclerView.ViewHolder {
    public CardView cardCountry;
    public TextView dialingCode;
    public TextView timezone;
    public TextView region;
    public TextView countryEn;
    public ImageView countryImage;

    public CountriesViewHolder(View itemView) {
        super(itemView);
        cardCountry = (CardView) itemView.findViewById(R.id.card_country);
        dialingCode = (TextView) itemView.findViewById(R.id.dialing_code);
        timezone = (TextView) itemView.findViewById(R.id.time_zone);
        region = (TextView) itemView.findViewById(R.id.region);
        countryEn = (TextView) itemView.findViewById(R.id.country_en);
        countryImage = (ImageView) itemView.findViewById(R.id.country_image);
    }
}
