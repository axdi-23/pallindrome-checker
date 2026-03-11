package PACKAGE_NAME;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PallindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("   UC6: Queue + Stack Palindrome Checker   ");

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println("\nResult: \"" + input + "\" is a Palindrome!");
        } else {
            System.out.println("\nResult: \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Core logic using Stack and Queue to validate palindrome status.
     */
    public static boolean checkPalindrome(String input) {
        // Normalize input: remove spaces/punctuation and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize Data Structures
        Queue<Character> queue = new LinkedList<>(); // FIFO
        Stack<Character> stack = new Stack<>();      // LIFO

        for (int i = 0; i < cleanInput.length(); i++) {
            char c = cleanInput.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                return false;
            }
        }

        return true;
    }
}