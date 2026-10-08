import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private String pin;
    private double balance;
    private List<String> transactions;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: Rs. " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add("Withdrawn: Rs. " + amount);
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactions.add("Deposited: Rs. " + amount);
        return true;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}