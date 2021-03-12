package me.com.lab3.model;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import me.com.lab3.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final String TAG = "VIEW_HOLDER";
    public TextView name;
    public TextView capital;
    public TextView region;

    private View itemView;
    private Bundle bundle;
    private Country country;

    public ViewHolder(View viewItem){
        super(viewItem);
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.text_name);
        capital = itemView.findViewById(R.id.text_capital);
        region = itemView.findViewById(R.id.text_region);
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG,"clicked" + itemView.toString());
        bundle = new Bundle();
        bundle.putInt("card", getAdapterPosition());
        bundle.putString("capital", capital.getText().toString());
        bundle.putString("region", region.getText().toString());
    }
}
