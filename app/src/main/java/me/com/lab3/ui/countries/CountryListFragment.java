package me.com.lab3.ui.countries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import java.util.List;

import me.com.lab3.R;
import me.com.lab3.model.Country;
import me.com.lab3.ui.controllers.GetData;
import me.com.lab3.ui.controllers.ItemRecycleView;

public class CountryListFragment extends Fragment {

    private CountryListViewModel countryListViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Country> countryList;
    private GetData getData;
    private RequestQueue queue;

    private String URL = "https://restcountries.eu/rest/v1/all";
    @Override
    public void onCreate(Bundle myBundle) {
        super.onCreate(myBundle);

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countryListViewModel =
                new ViewModelProvider(this).get(CountryListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countrys, container, false);

        adapter = new ItemRecycleView(R.layout.cardview_layout, countryList);
        queue = Volley.newRequestQueue(getContext());

        recyclerView = root.findViewById(R.id.my_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getData = new GetData(recyclerView, adapter, queue, this);
        getData.loadCountryData();
        adapter.notifyDataSetChanged();
        return root;
    }

}