package com.geniusforapp.countries.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.geniusforapp.countries.entites.EntityCountry;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ahmadnajar on 3/9/17.
 */

public class CountriesLoader {


    public CountriesLoader(Context context, OnLoadCountries onLoadCountries) {
        if (onLoadCountries != null && context != null) {
            new AsyncLoadCountries(context, onLoadCountries).execute();
        }
    }

    private static class AsyncLoadCountries extends AsyncTask<String, Void, ArrayList<EntityCountry>> {
        public static final String TAG = AsyncLoadCountries.class.getSimpleName();

        private Context context;
        private OnLoadCountries onLoadCountries;

        public AsyncLoadCountries(Context context, OnLoadCountries onLoadCountries) {
            this.context = context;
            this.onLoadCountries = onLoadCountries;
        }

        public AsyncLoadCountries(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            onLoadCountries.loading(true);
        }

        @Override
        protected ArrayList<EntityCountry> doInBackground(String... params) {
            ArrayList<EntityCountry> countries = new ArrayList<>();
            try {
                JSONArray response = null;
                try {
                    response = new JSONArray(readJsonCountries(context));
                } catch (IOException e) {
                    onLoadCountries.loading(false);
                    onLoadCountries.error(e.getLocalizedMessage());
                    Log.d(TAG, "doInBackground: " + e.getLocalizedMessage());
                }
                for (int i = 0; i < response.length(); i++) {
                    try {
                        countries.add(new Gson().fromJson(response.getJSONObject(i).toString(), EntityCountry.class));
                    } catch (JSONException e) {
                        Log.d(TAG, "onResponse: " + e.getLocalizedMessage());
                        onLoadCountries.loading(false);
                        onLoadCountries.error(e.getLocalizedMessage());
                    }
                }
                countries.addAll(countries);
            } catch (JSONException e) {
                onLoadCountries.loading(false);
                onLoadCountries.error(e.getLocalizedMessage());
            }

            return countries;
        }

        @Override
        protected void onPostExecute(ArrayList<EntityCountry> entityCountries) {
            super.onPostExecute(entityCountries);
            onLoadCountries.loading(false);
            onLoadCountries.loaded(entityCountries);

        }
    }

    private static String readJsonCountries(Context context) throws IOException {
        //Get Data From Text Resource File Contains Json Data.
        InputStream inputStream = context.getAssets().open("countries_v1.json");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }


    public interface OnLoadCountries {
        void loading(boolean loading);

        void loaded(ArrayList<EntityCountry> countries);

        void error(String error);
    }

}
