package test;

import org.junit.Test;
import static org.junit.Assert.*;
import app.StockLibrary;

public class StockLibraryTest {

    @Test
    public void testReduceStock() {
        String product = "Shampoo";
        int initial = StockLibrary.getStockLevel(product);
        StockLibrary.reduceStock(product, 10);
        assertEquals(initial - 10, StockLibrary.getStockLevel(product));

    }

    public void testLowStockAlert() {
        String product = "Aftercare";
        StockLibrary.reduceStock(product, 45);
        assertTrue(StockLibrary.getStockLevel(product) <= StockLibrary.LOW_STOCK_THRESHOLD);
    }
}
