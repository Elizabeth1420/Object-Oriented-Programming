package test;

import app.StockLibrary;
import app.StockMonitor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StockMonitorTest {

    @Test
    public void testLowStockAlertMessageAppears() {
        // force a product into a low stock state
        String lowStockProduct = "Aftercare";
        StockLibrary.reduceStock(lowStockProduct, 48);

        // capturing the console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        StockMonitor.checkLowStockLevels();

        // Restoring normal output
        System.setOut(System.out);

        // checking that low stock alert is printed
        String consoleOutput = output.toString();
        assertTrue("Low stock alert should appear for 'Aftercare'",
                consoleOutput.contains("ALERT: " + lowStockProduct + " is low in stock"));
    }

    public void testAllStockSufficientMessageAppears() {
        // rest stock to high values
        StockLibrary.addOrUpdateStock("Shampoo", 50);
        StockLibrary.addOrUpdateStock("Aftercare", 50);

        // capture the console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        StockMonitor.checkLowStockLevels();

        // restore normal output
        System.setOut(System.out);

        // checking that no low stock message is shown

        String consoleOutput = output.toString();
        assertTrue("Output should indicate all stock levls are sufficient",
                consoleOutput.contains("All Stock levels are sufficient"));
    }
}
