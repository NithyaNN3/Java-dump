import java.util.Scanner;
import java.util.Arrays;

// Every file, class and method should have documentation using the JavaDoc format
// Get a windows app version 
// Move print statements to debug statements, which are only printed if run with a --debug or -d flag. Create a Logger class.
/**
 * Public class to mock-up a game of Wordle
 */
public class InputArray {
    private boolean debug;
    
    public void Logger(boolean debug) {
        // fetches the debug flag
        this.debug = debug;
    }

    public void log(String message) {
        // Prints the log message
        if (debug) {
            System.out.println(message);
        }
    }

    /**
     * @return - sanitised word of the day
     */
    private String wordOfTheDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word of the day: ");

        String word = scanner.nextLine();

        return word.trim();
    }
    /**
     * @return - checks word of the day character limit
     */
    private boolean isFiveLetters(String word) {
        return word.length() == 5;
    }

    /**
     * @param word word of the day
     * @return whether the word of the day has numbers or not
     */
    private boolean containsNumbers(String word) {
        return word.matches(".*\\d.*"); // Checks if the word contains any digit
    }

    /**
     * Fetches user guess
     * @return user guess
     */
    private String fetchGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: ");

        String userGuess = scanner.nextLine();

        return userGuess.trim();
    }

    /**
     * Checks if a character is present in the same position in both words, different positions or if a character in the guess word
     * doesn't exist in the original word
     * @param word - sanitised word of the day
     * @param userGuess - sanitised recent user guess
     */
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
        
    /**
     * Is the main entry point for the code 
     * @param args
     */
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
}
