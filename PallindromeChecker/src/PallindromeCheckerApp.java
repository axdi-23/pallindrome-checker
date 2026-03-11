import java.util.Scanner;

/**
 * UC8: Linked List Based Palindrome Checker
 * Demonstrates the Fast/Slow pointer technique and In-Place Reversal.
 */
public class PallindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("      UC9: Recursive Palindrome Checker       ");
        System.out.println("==============================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Sanitize: remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) {
            System.out.println("Result: The input is empty.");
        } else if (isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive function to check palindrome.
     * @param str The cleaned string.
     * @param start The current left-side index.
     * @param end The current right-side index.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Condition 1: If pointers meet or cross, we've checked everything.
        if (start >= end) {
            return true;
        }

        // Base Condition 2: If characters at start and end don't match.
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Move pointers inward and call again.
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}