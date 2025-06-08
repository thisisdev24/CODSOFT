package ATM;

public class ATMInterface extends BankAccount {

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
