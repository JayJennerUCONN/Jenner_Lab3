package me.com.lab3.ui.controllers;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.com.lab3.model.Country;
import me.com.lab3.ui.countries.CountryListFragment;
import me.com.lab3.ui.countries.CountryListViewModel;

public class GetData {
    private RequestQueue queue;
    private String URL = "https://restcountries.eu/rest/v1/all";

    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    private CountryListViewModel countriesViewModel;
    public static ArrayList<Country> sCountryList = new ArrayList<Country>();



    public GetData(RecyclerView recyclerView, RecyclerView.Adapter adapter, RequestQueue queue, CountryListFragment countrylistfragment)
    {
        countriesViewModel = new ViewModelProvider(countrylistfragment).get(CountryListViewModel.class);
        this.queue = queue;
        this.adapter = adapter;
        this.recyclerView = recyclerView;
    }

    public void loadCountryData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray array = new JSONArray(response);
                            Log.i("PGB", "size: " + String.valueOf(array.length()));
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonData = array.getJSONObject(i);
                                String name = jsonData.getString("name");
                                String capital = jsonData.getString("capital");
                                String region = jsonData.getString("region");
                                Country country = new Country(name, capital, region);
                                sCountryList.add(country);
                            }
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        queue.add(stringRequest);
    }
}
