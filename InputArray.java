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
                System.out.println("Not the word!");
                continue;
            }
        }
    }
}