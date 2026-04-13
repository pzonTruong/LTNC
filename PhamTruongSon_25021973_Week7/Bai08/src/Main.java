import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ExecutorService pool1 = Executors.newFixedThreadPool(n);
        ExecutorService pool2 = Executors.newFixedThreadPool(n);
        
        List<Future<Long>> finalResults = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) arr[j] = sc.nextInt();

            final int arrayId = i;
            
            // Tạo một Task bắc cầu: Đợi Pool 1 xong rồi submit vào Pool 2
            // Việc bắc cầu này cũng chạy bất đồng bộ để không chặn luồng chính
            CompletableFuture<Long> pipeline = CompletableFuture.supplyAsync(() -> {
                try {
                    // Chạy Stage 1 trong Pool 1
                    return pool1.submit(new Stage1Task(arrayId, arr)).get();
                } catch (Exception e) { return new ArrayList<Integer>(); }
            }).thenCompose(primes -> {
                // Sau khi có kết quả Stage 1, đẩy sang Stage 2 trong Pool 2
                // thenCompose giúp nối hai Future lại với nhau
                return CompletableFuture.supplyAsync(() -> {
                    try {
                        return pool2.submit(new Stage2Task(arrayId, primes)).get();
                    } catch (Exception e) { return 0L; }
                });
            });

            // Chuyển CompletableFuture về Future thông thường để lấy kết quả ở cuối
            finalResults.add(pipeline.toCompletableFuture());
        }

        long total = 0;
        for (Future<Long> res : finalResults) {
            total += res.get();
        }

        System.out.println("Total = " + total);

        pool1.shutdown();
        pool2.shutdown();
        sc.close();
    }
}