
public class Solution {

    public long fibonacci(long n) {
        // Trường hợp n < 0
        if (n < 0) {
            return -1;
        }

        
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long f0 = 0;
        long f1 = 1;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            // Kiểm tra tràn số trước khi cộng:
            if (f1 > Long.MAX_VALUE - f0) {
                return Long.MAX_VALUE;
            }

            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }

        return fn;
    }
}
