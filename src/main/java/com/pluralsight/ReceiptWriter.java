package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {

        // Create receipts folder
        java.io.File folder = new java.io.File("receipts");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Create timestamp for filename
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        String filename = "receipts/receipt-" + timestamp + ".txt";

        // Build receipt text
        StringBuilder receipt = new StringBuilder();
        receipt.append("=====================================\n");
        receipt.append("      THE JALISCO GRILL BY LOS DÍAZ  \n");
        receipt.append("=====================================\n");
        receipt.append("Receipt #: ").append(timestamp).append("\n");
        receipt.append("Date: ").append(LocalDateTime.now()).append("\n");
        receipt.append("-------------------------------------\n");
        receipt.append(order.toString());  // order displays all items + totals
        receipt.append("-------------------------------------\n");
        receipt.append("Gracias! ¡Hasta la próxima!\n");
        receipt.append("=====================================\n");

        // SAVE receipt to file
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(receipt.toString());
            System.out.println("\n📄 Receipt saved to:");
            System.out.println("➡ " + filename);
        }
        catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }

        // ALSO print to console
        System.out.println("\n====== RECEIPT ======");
        System.out.println(receipt);
    }
}
