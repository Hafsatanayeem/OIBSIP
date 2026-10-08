import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("================================");
        System.out.println("        WELCOME TO ATM");
        System.out.println("================================");

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        Account account = bank.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            sc.close();
            return;
        }

        boolean authenticated = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");
            String pin = sc.next();

            if (account.verifyPin(pin)) {
                authenticated = true;
                System.out.println("\nLogin successful!");
                break;
            }

            System.out.println("Incorrect PIN.");

            if (attempt < 3) {
                System.out.println("Attempts remaining: " + (3 - attempt));
            }
        }

        if (!authenticated) {
            System.out.println("\nToo many incorrect attempts.");
            System.out.println("Your account has been temporarily blocked.");
            sc.close();
            return;
        }

        ATM atm = new ATM(account, bank, sc);
        atm.start();

        sc.close();
    }
}