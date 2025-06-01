package app;
public class Stock {
    private String stockName;
    private int stockQuantity;
    private double price; 

    public Stock(String stockName, int stockQuantity, double price) {
        this.stockName = stockName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    //Method to get StockName
    public String getStockName(){
         return stockName;
    }
       

     //Method to get StockQuantity
    public int getStockQuantity(){
         return stockQuantity;
    }


    //Method to get Price
    public double getPrice(){
         return price;
    }


    //Removing quantity
    public void removeQuantity(int quantityToRemove) {
        if (quantityToRemove <= stockQuantity) {
            stockQuantity -= quantityToRemove;
        } else {
            System.out.println("Not enough Stock Quantity to remove");

        }
    }

    public String toString() {
        return stockName + ", Stock Quantity: " + stockQuantity + ", Price: £ " + price;
    }

}
