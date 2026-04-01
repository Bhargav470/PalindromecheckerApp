import java.util.Stack;

/**
 * Project: Palindrome Pro
 * Use Case: UC5 - Stack-Based Palindrome Checker (LIFO Principle)
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC5 Mode ===");

        String input = "racecar";

        /*
         * UC5 Concept: Stack Data Structure
         * Java's built-in Stack class follows LIFO (Last In, First Out).
         */
        Stack<Character> stack = new Stack<>();

        // 1. Push Operation: Put each character into the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // 2. Pop and Compare: Build the reversed string
        // Because it's a stack, the last char pushed is the first char popped.
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Input: " + input);
        System.out.println("Stack-Reversed: " + reversed.toString());

        // 3. Validation
        if (input.contentEquals(reversed)) {
            System.out.println("Result: It is a palindrome!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
    }
}