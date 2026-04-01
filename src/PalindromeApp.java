import java.util.*;

/**
 * Project: Palindrome Pro
 * Use Case: UC12 - Strategy Pattern (Advanced Design Patterns)
 */

// 1. The Strategy Interface
interface PalindromeStrategy {
    boolean isValid(String input);
}

// 2. Implementation A: Stack Strategy (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        return clean.equals(reversed.toString());
    }
}

// 3. Implementation B: Two-Pointer Strategy (Optimized)
class PointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

// 4. The Context Class (The "Service" that uses a strategy)
class PalindromeContext {
    private PalindromeStrategy strategy;

    // Inject the strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String text) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isValid(text);
    }
}

// --- Main Application ---
public class PalindromeApp {
    public static void main(String[] args) {
        System.out.println("=== Palindrome Pro: UC12 Strategy Pattern ===");

        PalindromeContext context = new PalindromeContext();
        String testWord = "A man, a plan, a canal: Panama";

        // Scenario 1: Use Stack Strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Using Stack: " + context.executeCheck(testWord));

        // Scenario 2: Switch to Pointer Strategy dynamically
        context.setStrategy(new PointerStrategy());
        System.out.println("Using Pointer: " + context.executeCheck(testWord));
    }
}