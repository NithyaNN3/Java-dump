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

        System.out.println("Enter your guess: ");

        String userGuess = scanner.nextLine();
        char[] guessArray = new char[userGuess.length()];

        for (int i = 0; i < userGuess.length(); i++) {
            guessArray[i] = userGuess.charAt(i);
        }

        boolean areEqual = Arrays.equals(wordArray, guessArray);

        for (int i = 0; i < 5; i++) {
            if (areEqual) {
                System.out.println("You've got it!");
                break;
            } else {
                System.out.println("This is not the word");
            }
    }
}