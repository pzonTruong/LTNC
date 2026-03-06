
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testCases = {
            121,        // Palindrome dương
            -121,       // Số âm (không phải Palindrome)
            10,         // Số kết thúc bằng 0 (không phải Palindrome)
            0,          // Số 0 (là Palindrome)
            12321,      // Palindrome lẻ chữ số
            1221,       // Palindrome chẵn chữ số
            2147483647  // Số lớn nhất của int (không phải Palindrome)
        };

        for (int n : testCases) {
            boolean result = sol.isPalindrome(n);
            System.out.printf("n = %11d  =>  Is Palindrome? %b%n", n, result);
        }
    }
}
