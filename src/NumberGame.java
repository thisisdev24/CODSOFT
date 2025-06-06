import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    private int r_number, guess, attempts;
    Scanner input;

    NumberGame() {
        r_number = 0;
        guess = 0;
        attempts = 0;
        input = new Scanner(System.in);
    }

    void userGuess() {
        System.out.println("You have 7 attempts in total. \nEnter your guess: ");
        guess = input.nextInt();
        attempts++;
        if(attempts > 7) {
            System.out.println("Uh-oh! Out of attempts.");
            System.out.print("Restart Game? Y|N: \n");
            String restart = input.nextLine();
            if(restart.equals("Y")) {
                generateRandom();
            } else {
                System.exit(0);
            }
        }
        checkGuess();
    }

    void generateRandom() {
        System.out.println("New Number Generated!");
        r_number = new Random().nextInt(100) + 1;
        userGuess();
    }

    void checkGuess() {
        if(r_number == guess) {
            System.out.println("Correct!");
            System.out.print("Play again? Y|N: \n");
            String repeat = input.nextLine();
            if(repeat.equals("Y")) {
                userGuess();
            } else {
                System.exit(0);
            }
        } else if (r_number > guess ) {
            System.out.println("Too low! Try again.");
            userGuess();
        } else {
            System.out.println("Too High! Try again. ");
            userGuess();
        }
    }

    public static void main(String... args) {

    }
}
