package app;

public class Transaction {
    private String type;
    private String item;
    private int quantity;
    private double amount;
    
    public Transaction(String type, String item, int quantity, double amount) {
        this.type = type;
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
    }
    //Method to get Type
    public String getType() {
        return type;
    }
    
    //Method to get Item
    public String getItem() {
        return item;
    }
    
    //Method to get Quantity
    public int getQuantity() {
        return quantity;
    }

    //Method to get Amount
    public double getAmount() {
        return amount;
    }
   
    public String getSummary() {
        return type + " | " + item + " x" + quantity + " | £" + String.format("%.2f", amount);
    }
    
}
