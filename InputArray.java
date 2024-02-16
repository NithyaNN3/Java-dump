import java.util.Scanner;
import java.util.Arrays;

public class InputArray {
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