package test;

import static org.junit.Assert.*;
import app.*;
import app.ProductLibrary;
import app.PurchaseOrder;
import org.junit.Test;

public class PurchaseOrderTest {
    @Test
    public void testShippingAndGrandTotalCalculate() {
        // Arrange
        Product product = ProductLibrary.getProductByName("Shampoo");
        Supplier supplier = new Supplier(2001, "Test Supplier", 123565753);
        int quantity = 3;

        PurchaseOrder order = new PurchaseOrder(supplier, product, quantity);

        double expectedProductTotal = product.getProductPrice() * quantity;
        double expectedShipping = 5.00;
        double expectedGrandTotal = expectedProductTotal + expectedShipping;

        assertEquals("Shipping total should be £5.00", expectedShipping, order.getShippingTotal(), 0.001);
        assertEquals("Grand total should be correct", expectedGrandTotal, order.getGrandTotal(), 0.001);

    }

    public void testOrderSummaryContainsCorrectData() {
        Product product = ProductLibrary.getProductByName("Shampoo");
        Supplier supplier = new Supplier (2002, "Second Supplier", 998569473);
        int quantity = 2;

        PurchaseOrder order = new PurchaseOrder(supplier, product, quantity);
        String summary = order.getSummery();

        assertTrue("Summary should contain product name", summary.contains(product.getProductName()));
        assertTrue("Summary should contain supplier name", summary.contains(supplier.getSupplierName()));
        assertTrue("Summay should contain quantity", summary.contains(String.valueOf(quantity)));

    }

    public void testMarkAsDeliveredIncreasesStock() {
        Product product = ProductLibrary.getProductByName("Shampoo");
        Supplier supplier = new Supplier(2003, "Delivery Supplier", 657483920);
        int quantity = 4;

        int intitialStock = StockLibrary.getStockLevel(product.getProductName());
        
        PurchaseOrder order = new PurchaseOrder(supplier, product, quantity);
        order.markAsDelivered(); //should increase the stock

        int updatedStock = StockLibrary.getStockLevel(product.getProductName());

        assertEquals("Stock should increase by quantity delivered", intitialStock + quantity, updatedStock);
    }

}
