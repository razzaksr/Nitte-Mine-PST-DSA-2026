/*
Rules for an Immutable Class
    Make the class final (so it can’t be subclassed).
    Make all fields private and final.
    Don’t provide setters.
    If a field is mutable (like a list), return a copy instead of the original.
    Initialize all fields in the constructor.

Key Takeaway
Immutable = Safe & Predictable.
In banking, once an account snapshot is created, you don’t want outside code 
to change it secretly.
That’s why immutable classes are widely used in financial records, 
configuration objects, and multi‑threaded systems.
*/
import java.util.*;

final class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private final double balance;
    private final List<String> transactions;

    public BankAccount(String accountNumber, String holderName, double balance, List<String> transactions) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        // Defensive copy to keep immutability
        this.transactions = new ArrayList<>(transactions);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Return a copy, not the original list
    public List<String> getTransactions() {
        return new ArrayList<>(transactions);
    }
}

public class ImmutableDemo {
    public static void main(String[] args) {
        List<String> tx = new ArrayList<>();
        tx.add("Deposit 500");
        tx.add("Withdraw 200");

        BankAccount acc = new BankAccount("ACC101", "Arun", 300.0, tx);

        System.out.println(acc.getHolderName()); // Arun
        System.out.println(acc.getBalance());    // 300.0
        System.out.println(acc.getTransactions()); // [Deposit 500, Withdraw 200]

        // Try to modify transactions
        tx.add("Hack attempt!");
        System.out.println(acc.getTransactions()); // Still safe, no "Hack attempt!"
    }
}
