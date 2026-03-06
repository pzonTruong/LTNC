public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        long[] testCases = {-5, 0, 1, 10, 50, 92, 93, 100};

        for (long n : testCases) {
            long result = sol.fibonacci(n);
            String displayResult = (result == Long.MAX_VALUE) ? "Long.MAX_VALUE (Tràn số)" : String.valueOf(result);
            System.out.printf("n = %3d => Fibonacci: %s%n", n, displayResult);
        }
    }
}