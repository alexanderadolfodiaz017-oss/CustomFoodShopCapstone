package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {

        private List<Object> items = new ArrayList<>();

        public void addItem(Object item) {
            items.add(item);
        }

        public List<Object> getItems() {
            return items;
        }

        public double getTotal() {
            double total = 0;

            for (Object item : items) {
                if (item instanceof Burger b) total += b.getPrice();
                else if (item instanceof Drink d) total += d.getPrice();
                else if (item instanceof Side s) total += s.getPrice();
            }

            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (Object item : items)
                sb.append(item.toString()).append("\n");

            sb.append("\nTOTAL: $").append(String.format("%.2f", getTotal()));
            return sb.toString();
        }
    }


