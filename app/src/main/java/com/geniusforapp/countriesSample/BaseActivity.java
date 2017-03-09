package com.geniusforapp.countriesSample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.geniusforapp.countries.dialogs.CountriesDialog;
import com.geniusforapp.countries.entites.EntityCountry;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }

    public void select(View view) {
        CountriesDialog.Builder builder = new CountriesDialog.Builder(this).setOnCountrySelectedListener(new CountriesDialog.OnCountrySelectedListener() {
            @Override
            public void OnCountry(EntityCountry c, Dialog dialog) {
                Toast.makeText(BaseActivity.this, c.toString(), Toast.LENGTH_SHORT).show();
            }
        }).build();
        builder.show();
    }
}
