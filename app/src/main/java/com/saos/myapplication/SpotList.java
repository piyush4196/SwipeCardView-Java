package com.saos.myapplication;

import java.util.ArrayList;

public class SpotList {


    public static ArrayList<Spot> getList(){
        ArrayList<Spot> spots = new ArrayList<>();
        spots.add(new Spot(4, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        spots.add(new Spot(5, "Fushimi Inari Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        spots.add(new Spot(6, "Bamboo Forest", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        spots.add(new Spot(7, "Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        spots.add(new Spot(8, "Empire State Building", "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"));
        spots.add(new Spot(9, "The statue of Liberty", "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        spots.add(new Spot(10, "Louvre Museum", "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"));
        spots.add(new Spot(1, "Eiffel Tower", "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"));
        spots.add(new Spot(2, "Big Ben", "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"));
        spots.add(new Spot(3, "Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"));
        return spots;
    }

    public ArrayList<Spot> setList(ArrayList<Spot> listFriend) {
        ArrayList<Spot> spots = new ArrayList<>();
        spots = listFriend;
        return listFriend;
    }

    public ArrayList<Spot> getListItem() {
        ArrayList<Spot> spots = new ArrayList<>();
        return spots;
    }

}
