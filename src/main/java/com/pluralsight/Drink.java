package com.pluralsight;

public class Drink {
        private String size;
        private String flavor;

        public Drink(String size, String flavor) {
            this.size = size;
            this.flavor = flavor;
        }

        public double getPrice() {
            return switch (size) {
                case "1" -> 2.00;
                case "2" -> 2.50;
                case "3" -> 3.00;
                default -> 0;
            };
        }

        @Override
        public String toString() {
            return flavor + " (" + size + ") - $" + getPrice();
        }
    }

}
