import java.util.Scanner;
import java.util.Arrays;

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

        return word.trim();
    }

    private boolean isFiveLetters(String word) {
        return word.length() == 5;
    }

    private boolean containsNumbers(String word) {
        return word.matches(".*\\d.*"); // Checks if the word contains any digit
    }

    private String fetchGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: ");

        String userGuess = scanner.nextLine();

        return userGuess.trim();
    }

    private void checkGuess(String word, String userGuess) {
        int i;
        int j;

        for (i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            boolean charFound = false;
            boolean samePosition = false;

            for (j = 0; j < userGuess.length(); j++) {
                char currentGuessChar = userGuess.charAt(j);
                // logger.log("Comparing the guess with the word");
                if (currentGuessChar == currentChar) {
                    
                    charFound = true;

                    if (i == j) {
                        samePosition = true; // Character found in the same position
                    }
                }
            }
                
            if (charFound && samePosition) {
                // Character is in the same position in userGuess
                System.out.println(currentChar + " is in the right position");
            } else if (charFound && !samePosition) {
                // Character found in userGuess but at a different position
                System.out.println(currentChar + " is present in userGuess but at a different position");
            } else {
                // Character not present in word
                System.out.println(currentChar + " does not exist");
            }
            }
        }
        

    public static void main(String[] args) {
        InputArray obj = new InputArray();
        String word;
        int count = 0;

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

        do {
            String userGuess = obj.fetchGuess();
            obj.checkGuess(word, userGuess);

        } while (count < 5);
        
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
