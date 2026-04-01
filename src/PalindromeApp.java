/**
 * Project: Palindrome Pro
 * Use Case: UC1 - Application Entry & Welcome Message
 */
public class PalindromeApp {

    // Application Metadata (Constants)
    private static final String APP_NAME = "Palindrome Professional Suite";
    private static final String VERSION = "1.0.0-UC1";

    /**
     * Entry point of the application.
     * UC1: Displays branding and versioning upon startup.
     */
    public static void main(String[] args) {
        // Display UC1 Requirements
        displayWelcomeMessage();

        // Placeholder for future Use Cases (UC2: Navigation)
        System.out.println("\n[System]: Initialization complete. Ready for UC2 implementation.");
    }

    /**
     * Logic for UC1: Console Output
     */
    private static void displayWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("    " + APP_NAME);
        System.out.println("    Version: " + VERSION);
        System.out.println("========================================");
        System.out.println("System starting...");
    }
}