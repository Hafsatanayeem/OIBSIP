import java.util.Scanner;

public class ATM {

    private Account account;
    private Bank bank;
    private Scanner sc;

    public ATM(Account account, Bank bank, Scanner sc) {
        this.account = account;
        this.bank = bank;
        this.sc = sc;
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid choice: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    showHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void checkBalance() {
        System.out.printf("Current Balance: Rs. %.2f%n",
                account.getBalance());
    }

    private void withdraw() {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            System.out.printf("Please collect your cash: Rs. %.2f%n",
                    amount);
            System.out.printf("Remaining Balance: Rs. %.2f%n",
                    account.getBalance());
        } else {
            System.out.println(
                    "Transaction failed. Check the amount and your balance."
            );
        }
    }

    private void deposit() {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Amount deposited successfully.");
            System.out.printf("New Balance: Rs. %.2f%n",
                    account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void transfer() {

        System.out.print("Enter receiver account number: ");
        String receiver = sc.next();

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (bank.transfer(account.getAccountNumber(), receiver, amount)) {
            System.out.println("Transfer successful.");
            System.out.printf("Remaining Balance: Rs. %.2f%n",
                    account.getBalance());
        } else {
            System.out.println(
                    "Transfer failed. Check the account number, amount or balance."
            );
        }
    }

    private void showHistory() {

        System.out.println("\n====== TRANSACTION HISTORY ======");
        account.showTransactions();
        System.out.println("=================================");
    }
}