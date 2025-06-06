import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    private int r_number, guess, guessAttempts, score, attempts;
    Scanner input;

    NumberGame() {
        r_number = 0;
        guess = 0;
        attempts = 0;
        score = 0;
        input = new Scanner(System.in);
    }

    void userGuess() {
        System.out.println("Enter your guess: ");
        guess = input.nextInt();
        guessAttempts++;
        if(guessAttempts > 7) {
            System.out.println("Uh-oh! Out of attempts.");
            System.out.print("Restart Game? Y|N: \n");
            char restart = input.next().charAt(0);
            if(restart == 'Y') {
                generateRandom();
            } else {
                System.exit(0);
            }
        }
        checkGuess();
    }

    void generateRandom() {
        guessAttempts = 0;
        System.out.println("New Number Generated!");
        System.out.println("You have 7 attempts in total.");
        r_number = new Random().nextInt(100) + 1;
        attempts++;
        userGuess();
    }

    void checkGuess() {
        if(r_number == guess) {
            System.out.println("Correct!");
            score++;
            System.out.println("Final Score: " + score + "/" + attempts);
            System.out.print("Play again? Y|N: \n");
            char restart = input.next().charAt(0);
            if(restart == 'Y') {
                generateRandom();
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
        NumberGame ng = new NumberGame();
        ng.generateRandom();
    }
}
