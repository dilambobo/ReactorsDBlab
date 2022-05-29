package com.example.reactorslaba.dbReactor;

public class Country {

    int id;
    String name;
    int regionID;
    int col;
    private double consumption;

    public Country(int id, String name, int regionID) {
        this.id = id;
        this.name = name;
        this.regionID = regionID;
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

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = this.consumption + consumption;
    }
}
