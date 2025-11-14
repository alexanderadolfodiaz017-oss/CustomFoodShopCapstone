package com.pluralsight;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    // Home screen loop (keeps showing until user exits)
    public void showHomeScreen() {
        while (true) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║  THE JALISCO GRILL BY LOS DÍAZ  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1) New Order                 ║");
            System.out.println("║ 0) Exit                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> startNewOrder();   // start ordering
                case "0" -> {                  // exit program
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║     ¡Hasta la próxima!       ║");
                    System.out.println("║  We hope to see you again!   ║");
                    System.out.println("╚══════════════════════════════╝");
                    return;
                }
                default -> System.out.println("Invalid.");
            }
        }
    }

    private void startNewOrder() {
        Order order = new Order();     // new empty order
        showOrderScreen(order);        // go to order menu
    }

    // Order screen loop (keeps asking until checkout or cancel)
    private void showOrderScreen(Order order) {
        while (true) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          ORDER MENU          ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1) Burger                    ║");
            System.out.println("║ 2) Drink                     ║");
            System.out.println("║ 3) Side                      ║");
            System.out.println("║ 4) Checkout                  ║");
            System.out.println("║ 0) Cancel                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBurger(order);  // add burger
                case "2" -> addDrink(order);   // add drink
                case "3" -> addSide(order);    // add side
                case "4" -> checkout(order);   // finish order
                case "0" -> {
                    System.out.println("Order cancelled.");
                    return;
                }
                default -> System.out.println("Invalid.");
            }
        }
    }

    // Build burger with multiple steps
    private void addBurger(Order order) {

        System.out.println("Choose burger type:");
        System.out.println("1) Beef");
        System.out.println("2) Chicken");
        System.out.println("3) Veggie");
        String typeChoice = scanner.nextLine();

        // convert number → actual type
        String type = switch (typeChoice) {
            case "1" -> "Beef";
            case "2" -> "Chicken";
            case "3" -> "Veggie";
            default -> "Beef"; // fallback
        };

        // burger size
        System.out.println("Size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        String size = scanner.nextLine();

        // double patty?
        System.out.println("Special?");
        System.out.println("1) Double Patty");
        System.out.println("0) No");
        boolean special = scanner.nextLine().equals("1");

        Burger burger = new Burger(type, size, special); // create burger

        // toppings loop (lets user add many)
        boolean addMore = true;
        while (addMore) {
            showToppingMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> burger.addTopping(new Topping("Jalapeños", false, false));
                case "2" -> burger.addTopping(new Topping("Serrano", false, false));
                case "3" -> burger.addTopping(new Topping("Bacon", true, false));
                case "4" -> burger.addTopping(new Topping("Onion", false, false));
                case "5" -> burger.addTopping(new Topping("Bell Pepper", false, false));
                case "6" -> burger.addTopping(new Topping("Cactus (Nopal)", false, false));
                case "7" -> burger.addTopping(new Topping("Lettuce", false, false));
                case "8" -> burger.addTopping(new Topping("Tomato", false, false));
                case "9" -> burger.addTopping(new Topping("Cheese", true, false));
                case "10" -> burger.addTopping(new Topping("Avocado", true, false));
                case "0" -> addMore = false;  // stop toppings
                default -> System.out.println("Invalid.");
            }
        }

        order.addItem(burger); // add burger to order
        System.out.println("Burger added!");
    }

    // Add drink (simple selection)
    private void addDrink(Order order) {

        System.out.println("Size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        String size = scanner.nextLine();

        showDrinkMenu();
        String choice = scanner.nextLine();

        // convert number → drink type
        String flavor = switch (choice) {
            case "1" -> "Horchata";
            case "2" -> "Sprite";
            case "3" -> "Coke";
            case "4" -> "Coke Mex";
            case "5" -> "Corona";
            case "6" -> "Modelo";
            default -> "Water";
        };

        order.addItem(new Drink(size, flavor)); // add drink
        System.out.println(flavor + " added!");
    }

    // Add side (simple choice)
    private void addSide(Order order) {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║            SIDES             ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1) Churros + Fries           ║");
        System.out.println("║ 2) Nachos                    ║");
        System.out.println("║ 3) Fries                     ║");
        System.out.println("║ 0) Back                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();

        // convert number → side name
        String side = switch (choice) {
            case "1" -> "Churros + Fries";
            case "2" -> "Nachos";
            case "3" -> "Fries";
            default -> "Fries";
        };

        order.addItem(new Side(side)); // add side
        System.out.println(side + " added!");
    }

    // Final step (show order + save receipt)
    private void checkout(Order order) {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║           CHECKOUT           ║");
        System.out.println("╠══════════════════════════════╣");

        System.out.println(order); // print full order summary

        System.out.println("╚══════════════════════════════╝");

        System.out.println("1) Print Receipt");
        System.out.println("0) Cancel");

        if (scanner.nextLine().equals("1")) {

            // ⭐ FIXED — this now matches your ReceiptWriter method name ⭐
            ReceiptWriter.saveReceipt(order);

            System.out.println("Receipt saved!");
        }
    }

    // Drink menu
    private void showDrinkMenu() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║           DRINKS             ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1) Horchata                  ║");
        System.out.println("║ 2) Sprite                    ║");
        System.out.println("║ 3) Coke                      ║");
        System.out.println("║ 4) Coke Mex                  ║");
        System.out.println("║ 5) Corona                    ║");
        System.out.println("║ 6) Modelo                    ║");
        System.out.println("║ 0) Back                      ║");
        System.out.println("╚══════════════════════════════╝");
    }

    // Topping menu
    private void showToppingMenu() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║          TOPPINGS            ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1) Jalapeños                 ║");
        System.out.println("║ 2) Serrano                   ║");
        System.out.println("║ 3) Bacon (P)                 ║");
        System.out.println("║ 4) Onion                     ║");
        System.out.println("║ 5) Bell Pepper               ║");
        System.out.println("║ 6) Cactus (Nopal)            ║");
        System.out.println("║ 7) Lettuce                   ║");
        System.out.println("║ 8) Tomato                    ║");
        System.out.println("║ 9) Cheese (P)                ║");
        System.out.println("║ 10) Avocado (P)              ║");
        System.out.println("║ 0) Done                      ║");
        System.out.println("╚══════════════════════════════╝");
    }
}
