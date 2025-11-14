package com.pluralsight;

public class Menu {
    public void showHomeScreen() {
        while (true) {
            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║     THE JALISCO GRILL BY LOS DÍAZ  ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1) New Order                        ║");
            System.out.println("║ 0) Exit                             ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> startNewOrder();
                case "0" -> {
                    System.out.println("╔════════════════════════════════════╗");
                    System.out.println("║       ¡Hasta la próxima!           ║");
                    System.out.println("║   We hope to see you again soon!   ║");
                    System.out.println("╚════════════════════════════════════╝");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

}
