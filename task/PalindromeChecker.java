import java.util.*;

public class PalindromeChecker {

    public static void main(String[] args) {
        String inputString = "madam"; // Example input
        StringBuilder reversedString = new StringBuilder(inputString).reverse();
        if (inputString.equals(reversedString.toString())) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }
    }
}