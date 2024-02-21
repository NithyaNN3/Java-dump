import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Logger;

public class Logger {
    // constructor
    // Log method, takes a string as input and prints to stdout if debug flag set
    //
}

public class InputArray {

// Method: Set secret word (make sure to sanitise input)
// Method: Get user guess (make sure to sanitise guess input)
// Method: Check guess
// Method: Display guess feedback
// Every file, class and method should have documentation using the JavaDoc format
// Get a windows app version 
// Move print statements to debug statements, which are only printed if run with a --debug or -d flag. Create a Logger class.


    /* checkGuess
     * @secret: Word of the day that user needs to guess
     * @guess: Word provided by user
     * @output:
     */
    private void checkGuess(String secret, String, guess) {
        /*/ All comparison logic goes here
        for (i = 0; i < secret.length(); i++) {
            for (j = 0; j < guess.length(); j++) {
                // Logic
            }
        }
        //*/
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word of the day: ");

        String word = scanner.nextLine();
        char[] wordArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);
        }   

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter your guess: ");

            String userGuess = scanner.nextLine();
            char[] guessArray = new char[userGuess.length()];

            for (int j = 0; j < userGuess.length(); j++) {
                guessArray[j] = userGuess.charAt(j);
            }

            boolean areEqual = Arrays.equals(wordArray, guessArray);

            if (areEqual) {
                System.out.println("You've got it!");
                // Log.debug("You've got it!");
                break;
            } else {
                // Compare two arrays element by element
                for (int j = 0; j < wordArray.length; j++) {
                    for (int k = 0; k < guessArray.length; k++){
                        if (wordArray[j] == guessArray[k]) {
                            if (j==k) {
                                System.out.println(guessArray[k] + " is in the word at position" + j);
                            } else {
                                System.out.println(guessArray[k] + " is in the word but not in this position");
                            }
                        }
                    }
                }
                continue;
            }
        }
    }
}