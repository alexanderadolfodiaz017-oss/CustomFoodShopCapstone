package com.pluralsight;

public class Topping {

        private String name;
        private boolean premium;
        private boolean extra;

        public Topping(String name, boolean premium, boolean extra) {
            this.name = name;
            this.premium = premium;
            this.extra = extra;
        }

        public double getPrice(String size) {
            if (!premium) return 0;

            return switch (size) {
                case "1" -> 1.00;
                case "2" -> 2.00;
                case "3" -> 3.00;
                default -> 0;
            };
        }

        @Override
        public String toString() {
            return name;
        }
}
