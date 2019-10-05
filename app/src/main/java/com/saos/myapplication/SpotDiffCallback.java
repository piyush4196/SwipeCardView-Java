package com.saos.myapplication;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class SpotDiffCallback extends DiffUtil.Callback{

    ArrayList<Spot> old;
    ArrayList<Spot> neww;

    public SpotDiffCallback(ArrayList<Spot> old, ArrayList<Spot> neww) {
        this.old = old;
        this.neww = neww;
    }

    public int getOldListSize(){
        return old.size();
    }

     public int getNewListSize() {
        return neww.size();
     }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).id == neww.get(newItemPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == neww.get(newItemPosition);
    }


}
