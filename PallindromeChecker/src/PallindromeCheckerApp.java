import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return processed.equals(reversed);
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : processed.toCharArray()) {
            deque.add(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Main Application
public class PallindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Palindrome Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;

        // Inject strategy dynamically
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}