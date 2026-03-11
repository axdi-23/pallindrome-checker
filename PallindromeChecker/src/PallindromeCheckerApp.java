import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PallindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   UC7: Deque-Based Palindrome Checker      ");
        System.out.println("==============================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleanInput.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }
}