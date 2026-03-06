
public class Solution {
    public int reverse(int n) {
        long reversed = 0;

        while (n != 0) {
            int lastDigit = n % 10; 
            reversed = reversed * 10 + lastDigit;
            n /= 10; 
            
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) reversed;
    }
}
