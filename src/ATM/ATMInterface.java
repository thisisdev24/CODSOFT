package ATM;

import java.util.Scanner;

public class ATMInterface extends BankAccount {

    void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Successfully withdrawn!");
        } else {
            System.out.println("Not sufficient balance!");
        }
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited!");
    }

    double checkBalance() {
        return balance;
    }

    void userInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Deposit Cash");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice: ");
        short choice = sc.nextShort();

        double amount;
        switch (choice) {
            case 1 -> {
                System.out.print("\nEnter amount (in $): ");
                amount = sc.nextDouble();
                System.out.println("Depositing $" + amount + " ...");
                deposit(amount);
                userInterface();
            }
            case 2 -> {
                System.out.print("\nEnter amount (in $): ");
                amount = sc.nextDouble();
                System.out.println("Withdrawing $" + amount + " ...");
                withdraw(amount);
                userInterface();
            }
            case 3 -> {
                System.out.println("Current Account balance: $" + checkBalance());
                userInterface();
            }
            default -> System.exit(0);
        }
    }

    public static void main(String... args) {
        ATMInterface atm = new ATMInterface();
        System.out.println("Welcome to DBI ATM!");
        atm.userInterface();
    }
}
