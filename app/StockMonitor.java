package app;
import java.util.Map;

public class StockMonitor {
    //checking all stock and print low stock alerts
    public static void checkLowStockLevels() {
        System.out.println("\n--- Low Stock Report ---");
        boolean lowStockFound = false;

        for (Map.Entry<String, Integer> entry : StockLibrary.getStockMap().entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();

            if (quantity <= StockLibrary.LOW_STOCK_THRESHOLD) {
                System.out.println("ALERT: " + product + " is low in stock. Remaining: " + quantity);
                lowStockFound = true;
            }
        }
        if (!lowStockFound) {
            System.out.println("All stock levels are sufficient.");
        }
    }
    
}
