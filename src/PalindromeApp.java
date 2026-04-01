/**
 * Project: Palindrome Pro
 * Use Case: UC10 - Case-Insensitive & Space-Ignored (Preprocessing)
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Branding
        System.out.println("=== Palindrome Pro: UC10 Mode (Preprocessing) ===");

        // A complex phrase that is a palindrome but would fail UC2-UC9 without cleaning
        String rawInput = "A man, a plan, a canal: Panama";

        /**
         * UC10 Concept: String Preprocessing
         * 1. toLowerCase(): Standardizes 'A' and 'a'.
         * 2. replaceAll(): Uses Regex to remove everything that isn't a letter or number.
         */
        String cleanInput = rawInput.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("Raw Input:   " + rawInput);
        System.out.println("Cleaned:     " + cleanInput);

        // Applying the Two-Pointer logic from UC4 for efficiency
        if (checkPalindrome(cleanInput)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failed.");
        }
    }

    private static boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}