import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong mang n: ");
        int n = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futures = new ArrayList<>();

        // Nhập dữ liệu cho n mảng
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(executor.submit(new SecondLargestTask(i, arr)));
        }

        int totalSum = 0;
        for (Future<Integer> f : futures) {
            try {
                // get() sẽ lấy giá trị trả về từ call()
                totalSum += f.get();
            } catch (ExecutionException e) {
                // Nếu call() ném ra Exception, nó sẽ được bọc trong ExecutionException
                System.out.println(e.getCause().getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Sum = " + totalSum);
        executor.shutdown();
        sc.close();
    }
}