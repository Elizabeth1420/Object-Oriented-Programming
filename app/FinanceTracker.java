package app;

import java.util.ArrayList;
import java.util.List;

public class FinanceTracker {
    private static final List<Transaction> transactions = new ArrayList<>();

    public static void recordTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static void printSalesReport() {
        System.out.println("\n Sales Summery:");
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Sale")) {
                System.out.println(t.getSummary());
                total += t.getAmount();

            }
        }
        System.out.println("Total Sales: £" + String.format("%.2f", total));
    }

    public static void printExpenseReport() {
        System.out.println("\n Expense Summary:");
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Purchase")) {
                System.out.println(t.getSummary());
                total += t.getAmount();
            }
        }
        System.out.println("Total Expenses: £" + String.format("%.2f", total));
    }

}
