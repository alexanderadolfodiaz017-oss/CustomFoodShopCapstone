package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private String type;
    private String size;
    private boolean special;
    private List<Topping> toppings = new ArrayList<>();

    public Burger(String type, String size, boolean special) {
        this.type = type;
        this.size = size;
        this.special = special;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        double base = switch (size) {
            case "1" -> 5.50;
            case "2" -> 7.00;
            case "3" -> 8.50;
            default -> 0;
        };

        if (special) base += 2.00;

        double toppingCost = 0;
        for (Topping t : toppings)
            toppingCost += t.getPrice(size);

        return base + toppingCost;
    }

    @Override
    public String toString() {
        return type + " Burger - $" + String.format("%.2f", getPrice());
    }
}