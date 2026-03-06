
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testCases = {
            123,
            -456,
            120,
            0,
            1534236469,
            -2147483648
        };

        System.out.println("Kết quả đảo ngược số:");
        System.out.println("---------------------");
        for (int n : testCases) {
            int result = sol.reverse(n);
            System.out.printf("Input: %11d | Output: %11d%n", n, result);
        }
    }
}
