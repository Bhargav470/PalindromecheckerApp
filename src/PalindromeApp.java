/**
 * Project: Palindrome Pro
 * Use Case: UC9 - Recursive Palindrome Checker
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC9 Mode (Recursion) ===");

        String input = "kayak";

        // UC9 Flow: Initial recursive call
        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a recursive palindrome!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
    }

    /**
     * UC9 Concept: Recursive Method
     * This method calls itself with a smaller substring until it hits the base case.
     */
    public static boolean isPalindrome(String s) {
        // UC9 Concept: Base Condition 1
        // An empty string or single character is always a palindrome.
        if (s.length() <= 1) {
            return true;
        }

        // UC9 Concept: Recursive Step
        // 1. Check if the first and last characters match.
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // 2. If they match, call the method again with the "middle" substring.
            // Example: "kayak" -> calls isPalindrome("aya")
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        // If characters don't match, it's not a palindrome.
        return false;
    }
}