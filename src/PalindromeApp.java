/**
 * Project: Palindrome Pro
 * Use Case: UC11 - Object-Oriented Palindrome Service (Encapsulation)
 */

// --- The Service Provider ---
class PalindromeService {

    /**
     * UC11 Concept: Encapsulation
     * The logic is "hidden" inside this method. The user of this class
     * doesn't need to know IF it uses a Stack, Array, or Deque.
     */
    public boolean check(String input) {
        if (input == null) return false;

        // Internal Preprocessing (UC10 logic)
        String clean = sanitize(input);

        // Internal Logic (Using Two-Pointer for performance)
        return validate(clean);
    }

    private String sanitize(String s) {
        return s.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    private boolean validate(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

// --- The Application Entry Point ---
public class PalindromeApp {
    public static void main(String[] args) {
        System.out.println("=== Palindrome Pro: UC11 Mode (OOP) ===");

        // UC11 Concept: Object Instantiation
        // We create an 'instance' of the service to use its capabilities.
        PalindromeService service = new PalindromeService();

        String testPhrase = "No 'x' in Nixon";

        // UC11 Concept: Method Invocation
        boolean result = service.check(testPhrase);

        System.out.println("Testing: " + testPhrase);
        System.out.println("Result: " + (result ? "Verified Palindrome" : "Invalid"));
    }
}