import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;  // Generate a random number between 1 and 100
            int numberOfAttempts = 0;
            int maxAttempts = 5;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                    totalScore += maxAttempts - numberOfAttempts + 1;  // Higher score for fewer attempts
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            roundsPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();  // Consume the newline character
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You played " + roundsPlayed + " round(s) with a total score of " + totalScore + ".");
        scanner.close();
    }
}
