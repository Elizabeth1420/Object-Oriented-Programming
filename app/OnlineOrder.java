package app;
import java.util.Random;

public class OnlineOrder extends CustomerOrder {
    // additional attributes for delivery address and tracking number
    private String customerName;
    private String deliveryAddress;
    private String trackingNumber;

    // Constructor to intialise the OnlineOrder Object
    public OnlineOrder(String productName, int quantity, String customerName, String deliveryAddress) {
        // Calling superclass constructor to initalise common attritubes
        super(productName, quantity);
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = generateTrackingNumber();
    }

    //Method to generate a tracking number 
    private String generateTrackingNumber() {
        Random rand = new Random();
        int number = 100 + rand.nextInt(9000);
        return "TRK-" + number;
    }

    @Override
    public void processOrder() {
        //Getting the actual product name from the library
        Product product = ProductLibrary.getProductByName(getProductName());

        if (product == null) {
            System.out.println("Product not found: " + getProductName());
            return;
        }

        // checking to see if there's enough stock 
        int availableStock = StockLibrary.getStockLevel(product.getProductName());

        if (getQuantity() > availableStock) {
            System.out.println("Sorry, this product is Out of Stock.");
            return;
        }

        // reducing the stock 
        StockLibrary.reduceStock(product.getProductName(), getQuantity());

        // calculating and recording transaction
        double total = product.getProductPrice() * getQuantity();
        FinanceTracker.recordTransaction(
            new Transaction("Sale", product.getProductName(), getQuantity(), total));
        

        //Print order confirmation 
        System.out.println("Order Confirmed!");
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + product.getProductName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total: £" + String.format("%.2f", total));
        System.out.println("Processing online order for: " + customerName);
        System.out.println("Shipping to: " + deliveryAddress);
        System.out.println("Tracking No. : " + trackingNumber);
    }

}


















   