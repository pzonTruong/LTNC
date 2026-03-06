
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testNumbers = {
            -5, 0, 1, 2, 3, 4, 17, 25, 97, 100, 104729, 2147483647
        };

        for (int n : testNumbers) {
            boolean result = sol.isPrime(n);
            System.out.printf("n = %11d  =>  Is Prime? %b%n", n, result);
        }
    }
}
