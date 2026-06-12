/*
Quick Recap in Banking Terms
SRP: Teller only handles deposits/withdrawals, auditor only handles reports.
OCP: Add new loan types without touching old loan code.
LSP: A savings account should behave like any account; FD shouldn’t break expectations.
ISP: Don’t force FD to withdraw if it can’t.
DIP: Transaction depends on “notification service,” not on “email only.”
*/

// 1. Single Responsibility Principle (SRP)
// Definition (simple): One class = one job.
// 👉 Don’t mix “account transactions” and “report generation” in the same class.

class AccountService {
    public void deposit(double amount){ /* only deposit logic */ }
    public void withdraw(double amount){ /* only withdraw logic */ }
}

class ReportService {
    public void generateMonthlyReport(){ /* only reporting logic */ }
}

// 2. Open/Closed Principle (OCP)
// Definition (simple): Add new features without changing old code.
// 👉 If tomorrow you add a BusinessLoan, you just create a new class — no need to edit existing ones.

interface Loan {
    double calculateInterest();
}

class HomeLoan implements Loan {
    public double calculateInterest(){ return 8.5; }
}

class CarLoan implements Loan {
    public double calculateInterest(){ return 9.0; }
}


// 3. Liskov Substitution Principle (LSP)
// Definition (simple): Child classes should behave like their parent.
// 👉 FixedDepositAccount breaks LSP because it doesn’t behave like a normal Account.

class Account {
    public void withdraw(double amount){ /* generic withdraw */ }
}

class SavingsAccount extends Account { /* valid substitution */ }

class FixedDepositAccount extends Account {
    @Override
    public void withdraw(double amount){
        throw new UnsupportedOperationException("Cannot withdraw before maturity!");
    }
}

// 4. Interface Segregation Principle (ISP)
// Definition (simple): Don’t force classes to implement methods they don’t need.
// 👉 Separate interfaces so FixedDeposit isn’t forced to implement withdraw().

interface DepositService { void deposit(double amount); }
interface WithdrawService { void withdraw(double amount); }

class SavingsAccount implements DepositService, WithdrawService { /* both apply */ }

class FixedDeposit implements DepositService { /* only deposit, no withdraw */ }


// 5. Dependency Inversion Principle (DIP)
// Definition (simple): Depend on interfaces, not concrete classes.
// 👉 Transaction doesn’t care if it’s Email or SMS — it just uses the interface.
interface NotificationService { void notify(String msg); }

class EmailService implements NotificationService {
    public void notify(String msg){ System.out.println("Email: " + msg); }
}

class SMSService implements NotificationService {
    public void notify(String msg){ System.out.println("SMS: " + msg); }
}

class Transaction {
    private NotificationService service;
    Transaction(NotificationService service){ this.service = service; }
    public void complete(){ service.notify("Transaction successful!"); }
}
public class SOLID {
    public static void main(String[] args) {
        
    }
}
