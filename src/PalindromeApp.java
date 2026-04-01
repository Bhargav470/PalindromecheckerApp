import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A robust Palindrome Checker designed for modularity.
 * This app includes input cleaning, history tracking, and statistics.
 */
public class PalindromeApp {

    public static void main(String[] args) {
        AppController app = new AppController();
        app.start();
    }
}

// --- Logic Layer ---
class PalindromeEngine {

    /**
     * Checks if a string is a palindrome.
     * Uses a two-pointer approach for O(n) efficiency.
     */
    public boolean check(String input) {
        if (input == null || input.isEmpty()) return false;

        // Sanitize: remove non-alphanumeric and convert to lowercase
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// --- Data Layer ---
class SessionHistory {
    private final List<String> pastEntries = new ArrayList<>();

    public void addEntry(String entry, boolean isPalindrome) {
        String status = isPalindrome ? "[PASS]" : "[FAIL]";
        pastEntries.add(status + " " + entry);
    }

    public void showHistory() {
        System.out.println("\n--- Session History ---");
        if (pastEntries.isEmpty()) {
            System.out.println("No records found.");
        } else {
            pastEntries.forEach(System.out::println);
        }
    }
}

// --- Orchestration Layer ---
class AppController {
    private final Scanner scanner = new Scanner(System.in);
    private final PalindromeEngine engine = new PalindromeEngine();
    private final SessionHistory history = new SessionHistory();

    public void start() {
        boolean running = true;
        System.out.println("Welcome to the Palindrome Professional Suite 2026");

        while (running) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleSingleCheck();
                    break;
                case "2":
                    history.showHistory();
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Check a Word/Phrase");
        System.out.println("2. View Session History");
        System.out.println("3. Exit");
        System.out.print("Selection: ");
    }

    private void handleSingleCheck() {
        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();

        boolean result = engine.check(input);
        history.addEntry(input, result);

        if (result) {
            System.out.println(">> Result: It IS a palindrome!");
        } else {
            System.out.println(">> Result: Not a palindrome.");
        }
    }
}