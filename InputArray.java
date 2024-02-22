import java.util.Scanner;
import java.util.Arrays;
// Method: Set secret word (make sure to sanitise input)
// Method: Get user guess (make sure to sanitise guess input)
// Method: Check guess
// Method: Display guess feedback
// Every file, class and method should have documentation using the JavaDoc format
// Get a windows app version 
// Move print statements to debug statements, which are only printed if run with a --debug or -d flag. Create a Logger class.
public class InputArray {
    private boolean debug;
    
    public void Logger(boolean debug) {
        this.debug = debug;
    }

    public void log(String message) {
        if (debug) {
            System.out.println(message);
        }
    }

    /* checkGuess
     * @secret: Word of the day that user needs to guess
     * @guess: Word provided by user
     * @output:
     */

    private String wordOfTheDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word of the day: ");

        String word = scanner.nextLine();

        return word;
    }

    private boolean isFiveLetters(String word) {
        return word.length() == 5;
    }

    private boolean containsNumbers(String word) {
        return word.matches(".*\\d.*"); // Checks if the word contains any digit
    }


    // private void checkGuess(String secret, String guess) {
    //     /*/ All comparison logic goes here
    //     for (i = 0; i < secret.length(); i++) {
    //         for (j = 0; j < guess.length(); j++) {
    //             // Logic
    //         }
    //     }
    //     //*/
    // }

    public static void main(String[] args) {
        InputArray obj = new InputArray();
        String word;

        obj.Logger(true);
        obj.log("Entry point");

        do {
            word = obj.wordOfTheDay();

            if (!obj.isFiveLetters(word)) {
                System.out.println("The word entered is not five letters long. Please enter again.");
            } else if (obj.containsNumbers(word)) {
                System.out.println("The word entered contains numbers. Please enter again.");
            }
        } while (!obj.isFiveLetters(word) || obj.containsNumbers(word));
    }





        // for (int i = 0; i < word.length(); i++) {
        //     wordArray[i] = word.charAt(i);
        // }   

        // for (int i = 0; i < 5; i++) {
        //     System.out.println("Enter your guess: ");

        //     String userGuess = scanner.nextLine();
        //     char[] guessArray = new char[userGuess.length()];

        //     for (int j = 0; j < userGuess.length(); j++) {
        //         guessArray[j] = userGuess.charAt(j);
        //     }

        //     boolean areEqual = Arrays.equals(wordArray, guessArray);

        //     if (areEqual) {
        //         System.out.println("You've got it!");
        //         // Log.debug("You've got it!");
        //         break;
        //     } else {
        //         // Compare two arrays element by element
        //         for (int j = 0; j < wordArray.length; j++) {
        //             for (int k = 0; k < guessArray.length; k++){
        //                 if (wordArray[j] == guessArray[k]) {
        //                     if (j==k) {
        //                         System.out.println(guessArray[k] + " is in the word at position" + j);
        //                     } else {
        //                         System.out.println(guessArray[k] + " is in the word but not in this position");
        //                     }
        //                 }
        //             }
        //         }
        //         continue;
        //     }
        // }
    
}
