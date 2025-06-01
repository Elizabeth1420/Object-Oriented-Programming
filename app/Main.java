package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupplierLibrary supplierLibrary = new SupplierLibrary();
        SupplierLibrary getSupplierLibrary = new SupplierLibrary();
        boolean running = true;

        System.out.println("Welcome to BNU Industry Solutions Ltd!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("Enter 1 to add a Supplier");
            System.out.println("Enter 2 to remove a Supplier");
            System.out.println("Enter 3 to see Supplier Library");
            System.out.println("Enter 4 to see Purchase order");
            System.out.println("Enter 5 to add a Stock");
            System.out.println("Enter 6 to remove a Stock");
            System.out.println("Enter 7 to view Stocks");
            System.out.println("Enter 8 to check Low Stock Alerts");
            System.out.println("Enter 9 to process customer order");
            System.out.println("Enter 10 to view Sales Report");
            System.out.println("Enter 11 to view Expense Report");
            System.out.println("Enter 12 to exit");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            // Seeing supplier Library
            switch (userInput) {
                case 1:
                    // Option 1 - Adding suppliers
                    getSupplierLibrary.addSuppliers();
                    System.out.println("Your Supplier has now been added");
                    break;
                case 2:
                    System.out.println("Hey, you'd like to remove a supplier!");
                    getSupplierLibrary.removeSupplier();
                    break;
                case 3:
                    System.out.println("Here's the Supplier Library:");
                    getSupplierLibrary.printSuppliers();
                    break;
                case 4: {
                    ProductLibrary.printAvailableProducts();
                    System.out.print("Enter product name for purchase order: ");
                    String productName = scanner.nextLine().trim();
                    Product product = ProductLibrary.getProductByName(productName);

                    if (product == null) {
                        System.out.println("Product not found: ");
                        break;
                    }
                    Supplier supplier = supplierLibrary.getSupplierByName(product.getSupplierName());
                    if (supplier == null) {
                        System.out.println("Supplier not found.");
                        break;
                    }

                    System.out.print("Enter quantity to purchase: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    PurchaseOrder order = new PurchaseOrder(supplier, product, quantity);
                    System.out.println(order.getSummery());

                    System.out.print("Mark order as delivered? (yes/no): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("yes")) {
                        order.markAsDelivered();
                    } else {
                        System.out.println("Order remains in pending status.");
                    }

                    break;
                }
                // Adding and removing Inventory Stocks
                case 5:
                    StockLibrary.addOrUpdateStock(scanner);
                    break;
                case 6:
                    StockLibrary.removeStock(scanner);
                    break;
                case 7:
                    StockLibrary.displayStock();
                case 8:
                StockMonitor.checkLowStockLevels();
                break;
                case 9:
                    ProductLibrary.printAvailableProducts();

                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine().trim(); {
                    System.out.print("Enter quantity to order: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter delivery address: ");
                    String deliveryAddress = scanner.nextLine();

                    OnlineOrder onlineOrder = new OnlineOrder(productName, quantity, customerName, deliveryAddress);
                    onlineOrder.processOrder();
                    break;
                }
                case 10:
                    FinanceTracker.printSalesReport();
                    break;
                case 11:
                    FinanceTracker.printExpenseReport();
                    break;
                case 12:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid input. Please choose a valid option.");

            }

        }
        scanner.close();
    }
}

