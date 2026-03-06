
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testCases = {
            0,          // Số 0
            123,        // Số dương bình thường (1+2+3 = 6)
            -456,       // Số âm (-4-5-6 -> 4+5+6 = 15)
            1000,       // Số có nhiều chữ số 0
            999999      // Số lớn
        };

        System.out.println("Kết quả tính tổng các chữ số:");
        System.out.println("------------------------------");
        for (int n : testCases) {
            int result = sol.sumOfDigits(n);
            System.out.printf("Số n = %11d  => Tổng chữ số: %d%n", n, result);
        }
    }
}
