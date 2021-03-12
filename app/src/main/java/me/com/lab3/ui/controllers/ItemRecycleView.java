package me.com.lab3.ui.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import me.com.lab3.model.Country;
import me.com.lab3.model.ViewHolder;

public class ItemRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int layout_view;
    private ArrayList<Country> countryList;
    public ItemRecycleView(int id, ArrayList<Country> countryList){
        this.layout_view = layout_view;
        this.countryList = countryList;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_view,parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView name = ((ViewHolder) holder).name;
        TextView capital = ((ViewHolder) holder).capital;
        TextView region = ((ViewHolder) holder).capital;
        name.setText(countryList.get(position).name);
        capital.setText(countryList.get(position).capital);
        region.setText(countryList.get(position).region);
    }


    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
