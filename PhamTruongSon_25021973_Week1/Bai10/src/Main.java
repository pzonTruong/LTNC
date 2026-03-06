
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCases = {
            {10, 5, 10, 8, 9},    // Mảng bình thường, có trùng số lớn nhất (Kết quả: 9)
            {10, 10, 10},         // Mảng toàn số trùng nhau (Kết quả: -1)
            {5},                  // Mảng 1 phần tử (Kết quả: -1)
            {1, 2},               // Mảng 2 phần tử (Kết quả: 1)
            {-1, -5, -2, -1},     // Mảng số âm (Kết quả: -2)
            {5, 4, 3, 2, 1}       // Mảng giảm dần (Kết quả: 4)
        };

        System.out.println("Kết quả tìm số lớn thứ hai:");
        System.out.println("---------------------------");
        for (int[] arr : testCases) {
            int result = sol.secondLargest(arr);
            
            // In mảng để dễ theo dõi
            System.out.print("Mảng: [");
            for(int i=0; i<arr.length; i++) System.out.print(arr[i] + (i==arr.length-1?"":", "));
            System.out.println("] => Số lớn thứ 2: " + result);
        }
    }
}
