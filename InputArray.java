import java.util.Scanner;
// import javafx.application.Application;

// Get a windows app version 

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
        int correctPositions = 0;

        for (i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            char currentGuessChar = userGuess.charAt(i); // Get the character at the same position in userGuess
            boolean charFound = false;

            if (currentGuessChar == currentChar) {
                System.out.println(currentGuessChar + " is in the right position");
                correctPositions++;
            } else {
                // Check if the character exists in other positions of word
                for (j = 0; j < word.length(); j++) {
                    if (j != i && word.charAt(j) == currentGuessChar) {
                        // Character found in word but in the wrong position
                        System.out.println(currentGuessChar + " is in the word but in the wrong position");
                        charFound = true;
                        break;
                    }
                }
                // If character not found in other positions, it doesn't exist in word
                if (!charFound) {
                    System.out.println(currentGuessChar + " does not exist");
                }
        }
    }
        // Check if all characters are in the right position
        if (correctPositions == word.length()) {
            System.out.println("You've got it!");
            System.exit(0);
        }
    }
    /**
     * Is the main entry point for the code 
     * @param args
     */
    public static void main(String[] args) {
        boolean debugMode = false;
        if (args.length > 0 && (args[0].equals("-debug") || args[0].equals("--d"))) {
            debugMode = true;
        }
        InputArray obj = new InputArray();
        String word;
        String userGuess;
        int count = 0;

        obj.log("Entry point");

        do {
            word = obj.wordOfTheDay();
            obj.log("Word of the day: " + word);

            if (!obj.isFiveLetters(word)) {
                System.out.println("The word entered is not five letters long. Please enter again.");
            } else if (obj.containsNumbers(word)) {
                System.out.println("The word entered contains numbers. Please enter again.");
            }
        } while (!obj.isFiveLetters(word) || obj.containsNumbers(word));

        do {
            userGuess = obj.fetchGuess();
            obj.log("User guess: " + userGuess);

            if (!obj.isFiveLetters(userGuess)) {
                System.out.println("The word entered is not five letters long. Please enter again.");
            } else if (obj.containsNumbers(userGuess)) {
                System.out.println("The word entered contains numbers. Please enter again.");
            }
            
        } while (!obj.isFiveLetters(userGuess) || obj.containsNumbers(userGuess));

        do {
            obj.checkGuess(word, userGuess);
            count++;
        } while (count < 5);
        
    }
}
