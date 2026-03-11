import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
    String getName(); // For displaying algorithm name
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

    public String getName() {
        return "Stack Strategy";
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

    public String getName() {
        return "Deque Strategy";
    }
}

// Two-Pointer Strategy Implementation
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = processed.length() - 1;
        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getName() {
        return "Two-Pointer Strategy";
    }
}

// Main Application
public class PallindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("\nPerformance Comparison:");
        System.out.println("----------------------------");

        for (PalindromeStrategy strategy : strategies) {
            long start = System.nanoTime();
            boolean result = strategy.checkPalindrome(input);
            long end = System.nanoTime();
            long duration = end - start;

            System.out.printf("%s: %s (Execution time: %d ns)\n",
                    strategy.getName(),
                    result ? "Palindrome" : "Not Palindrome",
                    duration);
        }

        scanner.close();
    }
}