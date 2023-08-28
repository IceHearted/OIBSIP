import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println(" ");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (1-50)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-500)");
        System.out.println(" ");

        int difficultyChoice = scanner.nextInt();
        int maxNumber;

        switch (difficultyChoice) {
            case 1:
                maxNumber = 50;
                break;
            case 2:
                maxNumber = 100;
                break;
            case 3:
                maxNumber = 500;
                break;
            default:
                System.out.println(" ");
                System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                maxNumber = 100;
                break;
        }

        Random random = new Random();
        int targetNumber = random.nextInt(maxNumber) + 1;

        System.out.println(" ");
        System.out.println("I have selected a number between 1 and " + maxNumber + ". Can you guess it?");

        int playerGuess;
        int attempts = 0;

        do {
            System.out.println(" ");
            System.out.print("Enter your guess: ");
            playerGuess = scanner.nextInt();
            attempts++;

            if (playerGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                System.out.println(" ");
                System.out.println("Total attempts: " + attempts);
            } else if (playerGuess < targetNumber) {
                System.out.println("Try again! The target number is higher.");
            } else {
                System.out.println("Try again! The target number is lower.");
            }
        } while (playerGuess != targetNumber);

        int score = calculateScore(attempts, maxNumber);
        System.out.println(" ");
        System.out.println("Your score: " + score);
        System.out.println(" ");

        scanner.close();
    }

    private static int calculateScore(int attempts, int maxNumber) {
        // Calculate score based on the formula: (maxNumber * 10) - (attempts * 5)
        return (maxNumber * 10) - (attempts * 5);
    }
}
