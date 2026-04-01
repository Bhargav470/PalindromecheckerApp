/**
 * Project: Palindrome Pro
 * Use Case: UC13 - Performance Comparison (Benchmarking)
 */
public class PalindromeApp {

    public static void main(String[] args) {
        System.out.println("=== Palindrome Pro: UC13 Performance Comparison ===");

        // Create a massive string to make the performance difference noticeable
        String base = "racecar";
        String largeInput = base.repeat(10000);

        System.out.println("Testing input size: " + largeInput.length() + " characters.\n");

        // 1. Benchmark: String Reversal (UC3 style)
        long start = System.nanoTime();
        checkByReversal(largeInput);
        long end = System.nanoTime();
        System.out.println("String Reversal: " + (end - start) / 1000000.0 + " ms");

        // 2. Benchmark: Two-Pointer (UC4 style)
        start = System.nanoTime();
        checkByPointer(largeInput);
        end = System.nanoTime();
        System.out.println("Two-Pointer:    " + (end - start) / 1000000.0 + " ms");

        // 3. Benchmark: Recursion (UC9 style)
        // Warning: Recursion on very large strings can cause StackOverflowError
        System.out.println("Recursion:      Skipped (Risk of StackOverflow on 70k chars)");
    }

    private static void checkByReversal(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i); // String immutability makes this very slow!
        }
    }

    private static boolean checkByPointer(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}