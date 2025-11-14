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
        toppings.add(topping); // like adding ingredients to your burger
    }

    public double getPrice() {
        // base price depends on size (small/med/large)
        double base = switch (size) {
            case "1" -> 5.50;
            case "2" -> 7.00;
            case "3" -> 8.50;
            default -> 0;
        };

        if (special) base += 2.00; // special = extra charge (like double patty)

        double toppingCost = 0;
        // loop through toppings like checking each extra topping added
        for (Topping t : toppings)
            toppingCost += t.getPrice(size);

        return base + toppingCost; // final total price
    }

    @Override
    public String toString() {
        // formats how the burger appears on a receipt/menu line
        return type + " Burger - $" + String.format("%.2f", getPrice());
    }
}
