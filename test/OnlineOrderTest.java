package test;

import app.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OnlineOrderTest {

  @Test
  public void testOnlineOrderProcessing() {
    String productName = "Shampoo";
    int available = StockLibrary.getStockLevel(productName);
    if (available >= 1) {
      // creating an order for 1 item
      OnlineOrder order = new OnlineOrder(productName, 1, "Test Customer", "123 Test Street");
      order.processOrder();

      // verifying stock has decreased by 1
      assertEquals("Stock should decrease after order", available - 1, StockLibrary.getStockLevel(productName));
    } else {
      System.out.println("Not enough stock to test OnlineOrder processing.");
    }
  }

  // testing that an order with an invalid product does not throw errors or reduce
  // stock
  public void testOnlineOrderWithInvalidProduct() {
    OnlineOrder order = new OnlineOrder("InvalidProduct", 1, "Test", "Nowhere");
    order.processOrder(); // should output "Product not found"
    // confirming no crash or unhandled exception
  }

  public void testOnlineOrderOutOfStock() {
    String productName = "Aftercare";

    // ensuring the stock is very low
    StockLibrary.reduceStock(productName, 50);

    OnlineOrder order = new OnlineOrder(productName, 10, "Test", "Nowhere");

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // processing the order
    order.processOrder();

    // Restoring normal output
    System.setOut(System.out);

    // output should show "Out of Stock" message
    String output = out.toString();
    assertTrue("Should notify out of stock", output.contains("Sorry, this product is Out of Stock."));

  }
}
