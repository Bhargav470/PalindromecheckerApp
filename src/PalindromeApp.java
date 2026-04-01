import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Project: Palindrome Pro
 * Use Case: UC7 - Deque-Based Optimized Palindrome Checker
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC7 Mode ===");

        String input = "divider";

        /*
         * UC7 Concept: Deque (Double Ended Queue)
         * We use ArrayDeque for better performance than LinkedList.
         */
        Deque<Character> deque = new ArrayDeque<>();

        // 1. Insert characters into the deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        /*
         * 2. Comparison Logic: Remove First & Last
         * While there is more than one character, compare the ends.
         */
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input word: " + input);
        System.out.println("Result: " + (isPalindrome ? "Confirmed Palindrome" : "Not a Palindrome"));

        // UC7 Concept: Optimized Data Handling
        System.out.println("Status: Comparison finished with " + deque.size() + " characters remaining.");
    }
}