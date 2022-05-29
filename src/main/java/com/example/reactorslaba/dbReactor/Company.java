package com.example.reactorslaba.dbReactor;

public class Company {

    int id;
    String Name;
    int col;
    private double consumption;

    public Company(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
