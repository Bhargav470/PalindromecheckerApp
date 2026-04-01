/**
 * Project: Palindrome Pro
 * Use Case: UC8 - Singly Linked List (In-Place Reversal)
 */
public class PalindromeApp {

    // Helper Node class for the Singly Linked List
    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Pro: UC8 Mode (Linked List) ===");

        String input = "radar";
        Node head = buildLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println("Result: '" + input + "' is a linked list palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
    }

    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. UC8 Concept: Fast and Slow Pointers to find the middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. UC8 Concept: In-Place Reversal of the second half
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // 3. Compare the two halves
        Node temp = secondHalf; // Keep track to restore list if needed
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private static Node buildLinkedList(String s) {
        if (s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }
}