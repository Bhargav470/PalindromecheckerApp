/**
 * Project: Palindrome Pro
 * Use Case: UC3 - Palindrome Check Using String Reverse (Manual Loop)
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC3 Mode ===");

        // UC2: Data Setup
        String original = "level";
        StringBuilder reversed = new StringBuilder(); // Initialize an empty string to hold the result

        for (int i = original.length() - 1; i >= 0; i--) {
            // String Concatenation: Building the string character by character
            reversed.append(original.charAt(i));
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        if (original.equalsIgnoreCase(reversed.toString())) {
            System.out.println("Result: The strings match. It's a palindrome!");
        } else {
            System.out.println("Result: The strings do not match.");
        }
    }
}