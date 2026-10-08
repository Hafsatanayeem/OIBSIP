import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();

        accounts.put("1001", new Account("1001", "1234", 10000));
        accounts.put("1002", new Account("1002", "5678", 7500));
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {

        Account sender = accounts.get(fromAccount);
        Account receiver = accounts.get(toAccount);

        if (sender == null || receiver == null) {
            return false;
        }

        if (amount <= 0 || amount > sender.getBalance()) {
            return false;
        }

        if (!sender.withdraw(amount)) {
            return false;
        }

        receiver.deposit(amount);

        sender.addTransaction(
                "Transferred Rs. " + amount + " to Account " + toAccount
        );

        receiver.addTransaction(
                "Received Rs. " + amount + " from Account " + fromAccount
        );

        return true;
    }
}