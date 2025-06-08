package ATM;

public class ATMInterface {

    private double balance;

    void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
        }
    }

    void deposit(double amount) {
        balance += amount;
    }

    double checkBalance() {
        return balance;
    }
}
