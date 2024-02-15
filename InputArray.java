import java.util.Scanner;

public class InputArray {
    public static void main(String[] args) {
        Scanner wordOfTheDay = new Scanner(System.in);
        System.out.println("Enter the word of the day: ");

        String word = wordOfTheDay.nextLine();
        System.out.println("Word is: " + word);
    }
}