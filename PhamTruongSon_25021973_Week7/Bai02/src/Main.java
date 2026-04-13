import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bước 1: Nhập dữ liệu mảng
        System.out.print("Nhap so phan tu n: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Bước 2: Khởi tạo Thread Pool với số lượng luồng cố định (k = 4)
        int k = 4;
        ExecutorService executor = Executors.newFixedThreadPool(k);
        
        // Danh sách lưu các "phiếu hẹn" Future
        List<Future<Integer>> futures = new ArrayList<>();

        // Bước 3: Chia mảng và submit task
        int chunkSize = (int) Math.ceil((double) n / k);
        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);

            if (start < n) {
                SumTask task = new SumTask(array, start, end);
                // submit() trả về đối tượng Future ngay lập tức
                futures.add(executor.submit(task));
            }
        }

        // Bước 4: Thu thập kết quả
        int totalSum = 0;
        try {
            for (Future<Integer> future : futures) {
                // get() là hàm chặn (blocking), nó đợi thread hoàn thành rồi mới lấy giá trị
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Bước 5: Đóng ExecutorService để giải phóng tài nguyên
            executor.shutdown();
        }

        System.out.println("Tong cuoi cung: " + totalSum);
        sc.close();
    }
}