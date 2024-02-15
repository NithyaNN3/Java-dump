import java.util.Scanner;

public class InputArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word of the day: ");

        String word = scanner.nextLine();
        char[] wordArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);
        }

        System.out.println("Word stored in array: ");

        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
        }
    }
}