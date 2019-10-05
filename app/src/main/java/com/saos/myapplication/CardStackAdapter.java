package com.saos.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Spot> listItem;

    public CardStackAdapter(Context applicationContext, ArrayList<Spot> listItem) {
        this.context = applicationContext;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.test, parent, false);
        return new ViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //spot = new Spot(position);
        final String name = listItem.get(position).name;
        String url = listItem.get(position).URL;
        String city = listItem.get(position).city;
        holder.name.setText(name);
        holder.city.setText(city);
        Picasso.get().load(url).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return  listItem != null ? listItem.size() : 0;
    }

    public void setItem(ArrayList<Spot> listItem){
        this.listItem = listItem;
    }

    public ArrayList<Spot> getItem(){
        return listItem;
    }




    class ViewHolder extends RecyclerView.ViewHolder {
         TextView name;
         TextView city;
         ImageView image;

        ViewHolder(Context context, View view) {
            super(view);
            this.name =  view.findViewById(R.id.item_name);
            this.city =  view.findViewById(R.id.item_city);
            this.image = view.findViewById(R.id.item_image);
        }
    }

}

