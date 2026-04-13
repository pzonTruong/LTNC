import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong don hang m: ");
        int m = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(3); // Giả sử pool có 3 luồng
        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);
        List<Future<Boolean>> futures = new ArrayList<>();

        // Nhập dữ liệu và submit task
        for (int i = 0; i < m; i++) {
            System.out.print("Nhap ID don hang " + (i+1) + ": ");
            String id = sc.next();
            System.out.print("Nhap thoi gian xu ly (ms): ");
            long time = sc.nextLong();
            
            futures.add(executor.submit(new OrderProcessor(id, time, logs, successCount)));
        }

        // Đợi tất cả hoàn thành bằng Future.get()
        for (Future<Boolean> f : futures) {
            try {
                f.get(); 
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Đóng executor
        executor.shutdown();

        // In kết quả
        System.out.println("\n--- KET QUA ---");
        System.out.println("Success = " + successCount.get());
        System.out.println("Log (theo thu tu hoan thanh):");
        for (String log : logs) {
            System.out.println(log);
        }
        
        sc.close();
    }
}