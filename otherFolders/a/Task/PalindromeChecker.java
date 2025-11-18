package otherFolders.a.Task;
import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String inputString = sc.nextLine();

        StringBuilder reversedString = new StringBuilder(inputString).reverse();

        if (inputString.equals(reversedString.toString())) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }

        sc.close();
    }
}
