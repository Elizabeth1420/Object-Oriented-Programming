package app;

public class CustomerOrder {
     private String productName;
     private int quantity;

     public CustomerOrder(String productName, int quantity) {
          this.productName = productName;
          this.quantity = quantity;
     }

     public String getProductName() {
          return productName;
     }

     public int getQuantity() {
          return quantity;
     }
     // checking stocks and proccess the order
     public void processOrder() {
          // checking if product exist in stock
          if (!StockLibrary.hasProduct(productName)) {
               System.out.println("Product not found: " + productName);
               return;
          }

          // getting the current stock level for the product
          int availableStock = StockLibrary.getStockLevel(productName);

          // if there's not enough stock, show warning
          if (quantity > availableStock) {
               System.out.println("Not enough stock to fulfill order for " + productName);
          } else {
               // reduce stock if the order can be fufilled
               StockLibrary.reduceStock(productName, quantity);
               System.out.println("Order processed: " + quantity + " " + productName);

               // Warn if stock is low after processing
               if (StockLibrary.getStockLevel(productName) <= StockLibrary.LOW_STOCK_THRESHOLD) {
                    System.out.println("Low stock alert for " + productName);
               }
          }
     }

}

 