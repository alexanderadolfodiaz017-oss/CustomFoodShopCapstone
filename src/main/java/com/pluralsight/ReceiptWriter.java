package com.pluralsight;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public void writeReceipt(Order order) {
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            // Save in a receipts folder
            String fileName = "receipts/receipt-" + timestamp + ".txt";

            // Create folder if missing
            java.io.File folder = new java.io.File("receipts");
            if (!folder.exists()) folder.mkdir();

            FileWriter writer = new FileWriter(fileName);

            writer.write("=== The Jalisco Grill by Los Díaz ===\n\n");

            for (Object item : order.getItems()) {
                writer.write(item.toString() + "\n");
            }

            writer.write("\nTOTAL: $" + String.format("%.2f", order.getTotal()));

            writer.close();

            System.out.println("Receipt saved: " + fileName);

        } catch (Exception e) {
            System.out.println("Could not save receipt.");
            System.out.println(e.getMessage());
        }
    }
}
//