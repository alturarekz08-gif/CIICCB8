import java.util.Scanner;

public class JAVAatm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CORRECT_PIN = 1234;   // ✅ You can change this
        double balance = 1000.00;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        boolean isAuthenticated = false;

        System.out.println("==============================");
        System.out.println("   WELCOME TO JAVA ATM SYSTEM  ");
        System.out.println("==============================");

        // 🔑 PIN Login Section
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == CORRECT_PIN) {
                System.out.println("\n✅ Access Granted. Welcome!");
                isAuthenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("❌ Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (!isAuthenticated) {
            System.out.println("\n⚠ Too many incorrect attempts. Card blocked!");
            scanner.close();
            return; // exit the program
        }

        // 🏧 Main ATM Menu
        int choice;
        do {
            System.out.println("\n==============================");
            System.out.println("        MAIN MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n💰 Your current balance: ₱" + balance);
                    break;

                case 2:
                    System.out.print("\nEnter deposit amount: ₱");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("✅ Deposit successful!");
                    } else {
                        System.out.println("⚠ Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter withdrawal amount: ₱");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("💸 Please take your cash.");
                        System.out.println("(Tip: Use 'Check Balance' to view your updated amount.)");
                    } else if (withdraw > balance) {
                        System.out.println("⚠ Insufficient funds!");
                    } else {
                        System.out.println("⚠ Invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("\n👋 Thank you for using Java ATM!");
                    break;

                default:
                    System.out.println("\n⚠ Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
