package app;
import java.time.LocalDate;
import java.util.Random;

public class PurchaseOrder {
    private static final Random rand = new Random();
    private static final double FIXED_SHIPPING_COST = 5.00; //Standard fixed shipping cost 

 
    // additional attributes for purchase ID and tracking number
    private String orderId;
    private Supplier supplier;
    private Product product;
    private int quantity;
    private double productTotal;
    private double shippingTotal;
    private double grandTotal;
    private String status; 
    private LocalDate orderDate;

   
    public PurchaseOrder(Supplier supplier, Product product, int quantity) {
        this.orderId = generateOrderId();
        this.supplier = supplier; 
        this.product = product;
        this.quantity = quantity;
        this.productTotal = product.getProductPrice() * quantity;
        this.shippingTotal = FIXED_SHIPPING_COST;
        this.grandTotal = productTotal + shippingTotal;
        this.status = "Pending";
        this.orderDate = LocalDate.now();
        
        //Recording purchase transaction
        FinanceTracker.recordTransaction(
        new Transaction("Purchase", product.getProductName(), quantity, grandTotal));
    
    }

    private String generateOrderId() {
        int num = 1000 + rand.nextInt(9000);
        return "PO-" + num;
    }
        
    public void markAsDelivered() {
        this.status = "Delivered";
        StockLibrary.addOrUpdateStock(product.getProductName(), quantity);

    }

    public String getSummery() {
        return "Order #" + orderId +
        "| Product: " + product.getProductName() +
        " x " + quantity +
        "| Product Total: £" + String.format("%.2f", productTotal) +
        "| Shipping: £" + String.format("%.2f", shippingTotal) +
        "| Grand Total: £" + String.format("%.2f", grandTotal) +
        "| Supplier: " + supplier.getSupplierName() +
        "| Status: " + status;
    }

    //getters for shipping total
    public double getShippingTotal() {
        return this.shippingTotal;
    }
    //getters for grand toal
    public double getGrandTotal() {
        return this.grandTotal;
    }

}
