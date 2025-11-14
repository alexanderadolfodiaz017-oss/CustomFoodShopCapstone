package com.pluralsight;

public class Side {
    private String name;

    public Side(String name) {
        this.name = name;
    }

    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return name + " - $" + getPrice();
    }
}