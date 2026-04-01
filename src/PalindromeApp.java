import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Project: Palindrome Pro
 * Use Case: UC6 - Queue (FIFO) vs Stack (LIFO) Comparison
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC6 Mode ===");

        String input = "rotator";

        // UC6 Concepts: Queue (FIFO) and Stack (LIFO)
        // Note: LinkedList is used to implement the Queue interface in Java
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // 1. Enqueue and Push: Load both data structures
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            queue.add(c);  // Enqueue (adds to back)
            stack.push(c); // Push (adds to top)
        }

        boolean isPalindrome = true;

        // 2. Comparison Logic: Dequeue vs Pop
        // Queue.poll() returns the FIRST char added.
        // Stack.pop() returns the LAST char added.
        while (!queue.isEmpty()) {
            char fromQueue = queue.poll();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Result: " + (isPalindrome ? "It matches! Palindrome confirmed." : "Mismatch found."));
    }
}