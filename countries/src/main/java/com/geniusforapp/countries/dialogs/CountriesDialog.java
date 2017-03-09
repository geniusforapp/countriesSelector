package com.geniusforapp.countries.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geniusforapp.countries.R;
import com.geniusforapp.countries.adapter.CountriesAdapter;
import com.geniusforapp.countries.entites.EntityCountry;
import com.geniusforapp.countries.helpers.CountriesLoader;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ahmadnajar on 3/9/17.
 */

public class CountriesDialog extends BottomSheetDialogFragment implements TextWatcher {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static final String TAG = CountriesDialog.class.getSimpleName();
    private static CountriesDialog instance = new CountriesDialog();
    private RecyclerView listCountries;

    private TextView stateText;
    private ProgressBar progressBar;
    private LinearLayout stateLayout;
    private EditText search;
    private CountriesAdapter countriesAdapter;

    private Builder builder;

    private static CountriesDialog getInstance() {
        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            builder = (Builder) savedInstanceState.getSerializable(Builder.class.getSimpleName());
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(Builder.class.getSimpleName(), builder);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_countries, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList();
        new CountriesLoader(getContext(), new CountriesLoader.OnLoadCountries() {
            @Override
            public void loading(boolean loading) {
                stateLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void loaded(ArrayList<EntityCountry> countries) {
                stateLayout.setVisibility(View.GONE);
                countriesAdapter.addAll(countries);
            }

            @Override
            public void error(String error) {
                stateLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                stateText.setText(error);
            }
        });

        if (builder != null) {
            if (builder.getSearchIconDrawable() != null) {
                search.setCompoundDrawables(builder.getSearchIconDrawable(), null, null, null);
            } else if (builder.getSearchIconResource() != 0) {
                Drawable imageRes = VectorDrawableCompat.create(getResources(), builder.getSearchIconResource(), getActivity().getTheme());
                search.setCompoundDrawables(imageRes, null, null, null);
            }
        }


    }

    private void initList() {
        countriesAdapter = new CountriesAdapter(getActivity());
        listCountries.setItemAnimator(new DefaultItemAnimator());
        listCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        listCountries.setAdapter(countriesAdapter);
        if (builder != null) {
            countriesAdapter.setOnCountryClickListener(new CountriesAdapter.OnCountryClickListener() {
                @Override
                public void OnCountryClick(EntityCountry country) {
                    builder.getOnCountrySelectedListener().OnCountry(country, getDialog());
                }
            });
        }
    }

    private void initViews(View view) {
        listCountries = (RecyclerView) view.findViewById(R.id.list_countries);
        stateLayout = (LinearLayout) view.findViewById(R.id.state_layout);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        stateText = (TextView) view.findViewById(R.id.alert_text);
        search = (EditText) view.findViewById(R.id.edt_search);
        search.addTextChangedListener(this);
    }


    private Dialog show(Activity activity, Builder builder) {
        this.builder = builder;
        show(((AppCompatActivity) activity).getSupportFragmentManager(), TAG);
        return getDialog();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        countriesAdapter.filter(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public static class Builder implements Serializable {

        private Activity activity;

        private int searchIconResource;

        private Drawable searchIconDrawable;

        private OnCountrySelectedListener onCountrySelectedListener;


        public Builder(Activity activity) {
            this.activity = activity;
        }

        public OnCountrySelectedListener getOnCountrySelectedListener() {
            return onCountrySelectedListener;
        }

        public Builder setOnCountrySelectedListener(OnCountrySelectedListener onCountrySelectedListener) {
            this.onCountrySelectedListener = onCountrySelectedListener;
            return this;
        }

        public int getSearchIconResource() {
            return searchIconResource;
        }

        public Builder setSearchIconResource(int searchIconResource) {
            this.searchIconResource = searchIconResource;
            return this;
        }

        public Drawable getSearchIconDrawable() {
            return searchIconDrawable;
        }

        public Builder setSearchIconDrawable(Drawable searchIconDrawable) {
            this.searchIconDrawable = searchIconDrawable;
            return this;
        }


        public Builder build() {
            return this;
        }


        public Dialog show() {
            return CountriesDialog.getInstance().show(activity, this);
        }


    }


    public interface OnCountrySelectedListener {
        void OnCountry(EntityCountry c, Dialog dialog);
    }


}
