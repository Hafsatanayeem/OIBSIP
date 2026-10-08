import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        while (playAgain) {

            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy   - 15 attempts");
            System.out.println("2. Medium - 10 attempts");
            System.out.println("3. Hard   - 5 attempts");
            System.out.print("Enter your choice: ");

            int choice;

            while (!sc.hasNextInt()) {
                System.out.print("Please enter 1, 2 or 3: ");
                sc.next();
            }

            choice = sc.nextInt();

            while (choice < 1 || choice > 3) {
                System.out.print("Invalid choice. Enter 1, 2 or 3: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Please enter 1, 2 or 3: ");
                    sc.next();
                }

                choice = sc.nextInt();
            }

            int maxAttempts;

            if (choice == 1) {
                maxAttempts = 15;
            } else if (choice == 2) {
                maxAttempts = 10;
            } else {
                maxAttempts = 5;
            }

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Try to guess it!");

            while (attempts < maxAttempts) {

                System.out.print("\nAttempt " + (attempts + 1)
                        + "/" + maxAttempts + ": ");

                while (!sc.hasNextInt()) {
                    System.out.print("Enter a number between 1 and 100: ");
                    sc.next();
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! Congratulations!");
                    won = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }

            System.out.println("\n========== ROUND SUMMARY ==========");

            if (won) {
                System.out.println("Result   : WON");
                System.out.println("Attempts : " + attempts);
            } else {
                System.out.println("Result   : LOST");
                System.out.println("Attempts : " + attempts);
                System.out.println("The number was: " + number);
            }

            System.out.println("===================================");

            System.out.print("\nDo you want to play again? (Y/N): ");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");

        sc.close();
    }
}