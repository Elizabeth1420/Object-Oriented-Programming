package test;

import app.FinanceTracker;
import app.Transaction;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinanceTrackerTest {
    // testing a sale transaction can be recorded and does not break sales report
    @Test
    public void testRecordSalesTransaction() {
        Transaction transaction = new Transaction("Sale", "Shampoo", 2, 30.00);
        FinanceTracker.recordTransaction(transaction);

        // confirms there's no crash during output
        FinanceTracker.printSalesReport();
    }

    // testing that a purchase transaction is handled correctly
    public void testRecordPurchaseTransaction() {
        Transaction transaction = new Transaction("Purchase", "Conditoner", 5, 60.00);
        FinanceTracker.recordTransaction(transaction);

        // confirms that purchase transactions don't break the system
        FinanceTracker.printExpenseReport();
    }
}
