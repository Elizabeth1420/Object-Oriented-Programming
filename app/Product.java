package app;

public class Product {
    private int productId;
    private String productName;
    private int productQuantity;
    private double productPrice;
    private String supplierName;

    // Constructor to initalise the product
    public Product(int productID, String productName, String supplierName, int productQuantity, double productPrice) {
        this.productId = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.supplierName = supplierName;
    }

    // Method to get productID
    public int getProductId() {
        return productId;
    }

    // Method to get productName
    public String getProductName() {
        return productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    // Method to get productQuantity
    public int getProductQuantity() {
        return productQuantity;
    }

    // Method to get productQuantity
    public double getProductPrice() {
        return productPrice;
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("Product Quantity: " + productQuantity);
        System.out.println("Product Price: £" + productPrice);
    }

    public String getInfo() {
        return productId + " " + productName + " " + supplierName + " " + productQuantity + " " + productPrice;
    }

}