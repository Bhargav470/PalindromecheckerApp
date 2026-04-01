/**
 * Project: Palindrome Pro
 * Use Case: UC4 - Character Array & Two-Pointer Technique
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC4 Mode ===");

        // Data Setup
        String input = "deified";

        char[] charArray = input.toCharArray();

        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            // Compare characters at the current pointers
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break; // Exit loop early if a mismatch is found
            }
            // Move pointers closer to the middle
            left++;
            right--;
        }

        System.out.println("Input String: " + input);
        System.out.println("Result: " + (isPalindrome ? "It is a palindrome!" : "Not a palindrome."));

        // UC4 Concept: Time Complexity
        System.out.println("Optimization: Only " + (input.length() / 2) + " comparisons made.");
    }
}