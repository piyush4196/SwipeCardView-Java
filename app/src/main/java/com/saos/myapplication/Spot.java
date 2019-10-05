package com.saos.myapplication;

public class Spot {
    public int id;
    public String name;
    public String city;
    public String URL;


    public Spot(int id, String name, String city, String URL) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.URL = URL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
