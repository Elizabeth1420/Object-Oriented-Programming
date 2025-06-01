package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockLibrary {
    private static final Map<String, Integer> stock = new HashMap<>();
    public static Map<String, Integer> getStockMap() {
        return stock;
    }
    static {
        for (Product product : ProductLibrary.getAllProducts()) {
            stock.put(product.getProductName(), product.getProductQuantity());
        }
    }
    // Threshold for when the stock is considered low
    public static final int LOW_STOCK_THRESHOLD = 5;

    // Checking if a product exisits in the stock
    public static boolean hasProduct(String productName) {
        return stock.containsKey(productName);
    }

    // Getting the current stock level for a product
    public static int getStockLevel(String productName) {
        return stock.getOrDefault(productName, 0);
    }

    // reduce the stock level for a product by a given amount

    public static void reduceStock(String productName, int amount) {
        int current = stock.get(productName);
        stock.put(productName, Math.max(0, current - amount));
    }

    // add Stock
    public static void addOrUpdateStock(Scanner scanner) {

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine().trim();

        int quantity = 0;
        while (true) {
            System.out.print("Enter quantity to add: ");
            String input = scanner.nextLine().trim();
            try {
                quantity = Integer.parseInt(input);
                if (quantity < 0) {
                    System.out.println("Quantity must be a positive number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        stock.put(productName, stock.getOrDefault(productName, 0) + quantity);
        System.out.println(productName + " stock updated.");
        displayStock();

    }

    // Method for automatic stock updates
    public static void addOrUpdateStock(String productName, int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity must be positive");
            return;
        }
        stock.put(productName, stock.getOrDefault(productName, 0) + quantity);
        System.out.println(productName + " stock increased by " + quantity + ".");
        displayStock();

    }

    // Option 2 removing stock

    public static void removeStock(Scanner scanner) {
        displayStock(); // showing current products

        System.out.print("Enter product name to remove stock: ");
        String productName = scanner.nextLine().trim();

        int quantity = 0;
        while (true) {
            System.out.print("Enter Quantity to remove: ");
            String input = scanner.next().trim();
            try {
                quantity = Integer.parseInt(input);
                if (quantity < 0) {
                    System.out.println("Quantity must be positive.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        int current = stock.get(productName);
        int newQuantity = Math.max(0, current - quantity);
        stock.put(productName, newQuantity);

        System.out.println(productName + " stock reduced to " + newQuantity);
        displayStock();

        if (stock.get(productName) <= LOW_STOCK_THRESHOLD) {
            System.out.print("WARNING: " + productName + " is running low! ");
        }
    }

    public static void displayStock() {
        System.out.println("\nCurrent Stock Levels:");
        if (stock.isEmpty()) {
            System.out.println("No stock available.");
            return;
        }

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            String alert = (quantity <= LOW_STOCK_THRESHOLD) ? " LOW STOCK! " : "";
            System.out.println(productName + " : " + quantity + alert);
        }

    }

}
