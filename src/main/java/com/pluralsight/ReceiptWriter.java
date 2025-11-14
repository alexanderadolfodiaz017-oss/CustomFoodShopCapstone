package com.pluralsight;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public void writeReceipt(Order order) {
        try {
            // Create a timestamp so each receipt file has a unique name
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            // This opens a new text file to write the receipt into
            FileWriter writer = new FileWriter("receipt-" + timestamp + ".txt");

            writer.write("=== The Jalisco Grill by Los Díaz ===\n\n");

            // Write each item in the order
            for (Object item : order.getItems())
                writer.write(item.toString() + "\n");

            // Write the total price at the end
            writer.write("\nTOTAL: $"
                    + String.format("%.2f", order.getTotal()));

            writer.close(); // finish writing and save the file
        } catch (Exception e) {
            System.out.println("Could not save receipt.");
        }
    }
}
