import java.util.Scanner;

/**
 * UC8: Linked List Based Palindrome Checker
 * Demonstrates the Fast/Slow pointer technique and In-Place Reversal.
 */
public class PallindromeCheckerApp {

    // Internal Node class must be static to be used by static methods
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   UC8: Linked List Palindrome Checker      ");
        System.out.println("==============================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Clean input and build the Singly Linked List
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) {
            System.out.println("Input is empty or contains no valid characters.");
            return;
        }

        Node head = buildLinkedList(cleanInput);

        // Step 2: Check if palindrome using optimized pointer logic
        if (isPalindrome(head)) {
            System.out.println("\nResult: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\nResult: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    private static Node buildLinkedList(String s) {
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle using Fast & Slow pointers
        // Fast moves 2x, Slow moves 1x. When Fast hits the end, Slow is at middle.

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list in-place

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // 3. Compare the two halves
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}