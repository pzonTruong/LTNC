
public class Solution {
    public boolean isPalindrome(int n) {
        // 1. Các số âm không thể là số Palindrome (ví dụ: -121 đảo ngược thành 121-)
        if (n < 0) {
            return false;
        }

        // 2. Các số có chữ số 0 ở cuối (ngoại trừ chính số 0) không phải là Palindrome
        // Vì số đảo ngược sẽ có chữ số 0 ở đầu (không hợp lệ)
        if (n != 0 && n % 10 == 0) {
            return false;
        }

        int original = n;
        long reversed = 0; // Dùng long để tránh tràn số khi đảo ngược

        while (n > 0) {
            int lastDigit = n % 10;
            reversed = reversed * 10 + lastDigit;
            n /= 10;
        }

        // 3. So sánh số đảo ngược với số ban đầu
        return (int) reversed == original;
    }
}
