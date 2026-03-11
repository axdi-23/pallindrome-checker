import java.util.Scanner;
import java.util.Stack;

// PalindromeChecker class (Encapsulation)
class pallindrome {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {

        // Remove spaces and convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        // Build reversed string using stack
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original processed string with reversed string
        return processed.equals(reversed);
    }
}

// Main Application Class
public class PallindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        pallindrome checker = new pallindrome();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}