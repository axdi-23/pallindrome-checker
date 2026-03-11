import java.util.Scanner;

public class PallindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   UC10: Robust Palindrome Checker (Regex)    ");
        System.out.println("==============================================");

        System.out.print("Enter a phrase or string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string (Remove spaces, punctuation, and ignore case)
        String cleanInput = normalizeString(input);

        // Step 2: Validate and display result
        if (cleanInput.isEmpty()) {
            System.out.println("Result: No alphanumeric characters found to check.");
        } else if (isPalindrome(cleanInput)) {
            System.out.println("\nOriginal: " + input);
            System.out.println("Normalized: " + cleanInput);
            System.out.println("Result: This is a Palindrome!");
        } else {
            System.out.println("\nResult: This is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Logic for Normalization using Regular Expressions
     */
    public static String normalizeString(String str) {
        // [^a-zA-Z0-9] replaces everything that IS NOT a letter or number with ""
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Logic for Palindrome Check using Two-Pointer technique
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;



        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}