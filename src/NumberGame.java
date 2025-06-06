import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    private int r_number, guess;

    void userGuess() {
        System.out.println("Enter your guess: ");
        guess = new Scanner(System.in).nextInt();
    }

    void generateRandom() {
        System.out.println("New Number Generated!");
        r_number = new Random().nextInt(100) + 1;
    }
}
