import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(n);
        List<Future<Integer>> futures = new ArrayList<>();

        // Nhập dữ liệu và khởi chạy các luồng song song
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(executor.submit(new PrimeCountTask(i, arr)));
        }

        int[] results = new int[n];
        int maxPrimes = -1;

        // Thu thập kết quả
        for (int i = 0; i < n; i++) {
            try {
                results[i] = futures.get(i).get();
                System.out.println("Array " + i + ": " + results[i]);
                
                if (results[i] > maxPrimes) {
                    maxPrimes = results[i];
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Tìm và in các mảng đứng đầu
        System.out.print("Most primes: ");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (results[i] == maxPrimes && maxPrimes > 0) {
                if (!first) System.out.print(", ");
                System.out.print("Array " + i);
                first = false;
            }
        }
        if (maxPrimes > 0) System.out.println(" with " + maxPrimes + " primes");
        else System.out.println("No primes found.");

        executor.shutdown();
        sc.close();
    }
}