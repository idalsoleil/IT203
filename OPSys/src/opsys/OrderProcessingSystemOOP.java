package opsys;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderProcessingSystemOOP {

    private static final String FILE_NAME = "C:\\Users\\huawei\\Downloads\\inventory.txt";

    public static void main(String[] args) {

        List<Item> inventory = loadInventory(); // Load inventory from file
        List<String> generateReceipt = new ArrayList<>(); // List to store receipt details
        double totalCost = 0; // Variable to track total cost of the order

        if (inventory.isEmpty()) {
            System.out.println("Inventory could not be loaded.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        boolean ordering = true; // Flag to control the ordering loop

        while (ordering) {
            System.out.println("\nAvailable items and their details:");
            printInventory(inventory); // Print available inventory

            int itemIndex = -1;
            boolean validItem = false;

            // Handle invalid item index input
            while (!validItem) {
                System.out.print("\nEnter the item number you want to order: ");
                try {
                    itemIndex = Integer.parseInt(scanner.nextLine()) - 1; // Adjust for 0-based index

                    if (itemIndex < 0 || itemIndex >= inventory.size()) {
                        System.out.println("Invalid item number. Please select a valid item number.");
                    } else {
                        validItem = true; // Valid item selected
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid item number.");
                }
            }

            Item item = inventory.get(itemIndex); // Get the selected item
            if (item.getQuantity() == 0) {
                System.out.println("Sorry, this item is out of stock.");
            } else {
                int orderQuantity = -1;
                boolean validQuantity = false;

                // Handle invalid quantity input
                while (!validQuantity) {
                    System.out.print("Enter quantity to order: ");
                    try {
                        orderQuantity = Integer.parseInt(scanner.nextLine()); // Read order quantity

                        if (orderQuantity < 1) {
                            System.out.println("Quantity must be a positive integer.");
                        } else if (orderQuantity > item.getQuantity()) {
                            System.out.println("Not enough stock available.");
                        } else {
                            validQuantity = true; // Valid quantity selected
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for quantity.");
                    }
                }

                if (validQuantity) {
                    double orderCost = orderQuantity * item.getPrice(); // Calculate order cost
                    item.setQuantity(item.getQuantity() - orderQuantity); // Update item stock
                    totalCost += orderCost; // Add to total cost
                    generateReceipt.add(item.getName() + " x" + orderQuantity + " - " + String.format("%.2f", orderCost)); // Add to receipt
                    System.out.printf("Order processed: %s x%d for %.2f%n", item.getName(), orderQuantity, orderCost);
                }
                saveInventory(inventory); // Save updated inventory to file
            }

            // Handle invalid input for ordering again
            boolean validInput = false;
            while (!validInput) {
                System.out.print("\nDo you want to order another item? (Y/N): ");
                String response = scanner.nextLine().trim().toUpperCase();

                switch (response) {
                    case "Y":
                        ordering = true;
                        validInput = true;
                        break;
                    case "N":
                        ordering = false;
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
                        break;
                }
            }
        }

        // Ask the customer for their name
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer c = new Customer(customerName); // Create customer object

        // Print Receipt
        System.out.println("\n---------------------------------------------");
        System.out.println("                     Receipt");
        System.out.println("---------------------------------------------");

        // Customer Name and Date
        String currentDate = new SimpleDateFormat("MM/dd/yy").format(new java.util.Date());
        System.out.printf("Name: %-25s Date: %s%n", c.getCustomerName(), currentDate);
        System.out.println("---------------------------------------------");

        // Table Header
        System.out.printf("%-20s %-5s %-10s%n", "Item", "Qty", "Price");
        System.out.println("---------------------------------------------");

        // Print each item in receipt
        for (String line : generateReceipt) {
            String[] parts = line.split(" x| - ");
            String itemName = parts[0];
            String qty = parts[1];
            String price = parts[2];
            System.out.printf("%-20s %-5s %-10s%n", itemName, qty, price);
        }

        // Subtotal, Cash, and Balance Section
        System.out.println("---------------------------------------------");
        System.out.printf("%-20s %18.2f%n", "Sub Total:", totalCost);

        double payment = 0;
        boolean validPayment = false;
        while (!validPayment) {
            try {
                System.out.print("\nEnter payment amount: ");
                payment = Double.parseDouble(scanner.nextLine());

                if (payment < totalCost) {
                    System.out.println("Insufficient payment. Please enter a sufficient amount.");
                } else {
                    validPayment = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }

        double change = payment - totalCost;

        System.out.printf("%-20s %18.2f%n", "Cash:", payment);
        System.out.printf("%-20s %18.2f%n", "Balance:", change);

        System.out.println("---------------------------------------------");
        System.out.println("           Thank you for buying!");
        System.out.println("---------------------------------------------");
    }

    // Load inventory from file
    private static List<Item> loadInventory() {
        List<Item> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String itemName = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    inventory.add(new Item(itemName, quantity, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
        return inventory;
    }

    // Save updated inventory to file
    private static void saveInventory(List<Item> inventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : inventory) {
                writer.write(item.getName() + "," + item.getQuantity() + "," + item.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Print inventory
    private static void printInventory(List<Item> inventory) {
        System.out.println("Item Number | Name          | Quantity | Price ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.printf("%-11d | %-12s | %-8d | %.2f%n", i + 1, item.getName(), item.getQuantity(), item.getPrice());
        }
    }
}