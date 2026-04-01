/**
 * Project: Palindrome Pro
 * Use Case: UC2 - Print a Hardcoded Palindrome Result
 */
public class PalindromeApp {

    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("=== Palindrome Pro: UC2 Mode ===");

        // UC2: Hardcoded String Logic
        // We use a String literal "madam" as our test case
        String testWord = "madam";

        // Logic to check palindrome: Reverse the string
        // We use StringBuilder for an easy reverse() method
        String reversedWord = new StringBuilder(testWord).reverse().toString();

        System.out.println("Testing word: " + testWord);

        // UC2: Conditional Statement (if-else)
        if (testWord.equals(reversedWord)) {
            System.out.println("Result: Success! '" + testWord + "' is a palindrome.");
        } else {
            System.out.println("Result: Fail. '" + testWord + "' is not a palindrome.");
        }

        System.out.println("Program execution finished.");
    }
}