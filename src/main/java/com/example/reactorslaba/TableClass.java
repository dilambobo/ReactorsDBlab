package com.example.reactorslaba;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableClass {
    SimpleStringProperty name;
    SimpleDoubleProperty consumption;

    public TableClass(SimpleStringProperty name, SimpleDoubleProperty consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getConsumption() {
        return consumption.get();
    }

    public SimpleDoubleProperty consumptionProperty() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption.set(consumption);
    }
}
