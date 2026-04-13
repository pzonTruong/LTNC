import java.util.List;
import java.util.concurrent.Callable;

public class Stage2Task implements Callable<Long> {
    private final int id;
    private final List<Integer> primes;

    public Stage2Task(int id, List<Integer> primes) {
        this.id = id;
        this.primes = primes;
    }

    @Override
    public Long call() {
        long result = 0;
        int size = primes.size();
        
        if (size == 0) {
            System.out.println("Stage 2 - Array " + id + ": No primes");
            return 0L;
        }

        if (size % 2 == 0) {
            // Chẵn: Tổng bình phương
            for (int x : primes) result += (long) x * x;
            System.out.println("Stage 2 - Array " + id + ": sum of squares = " + result);
        } else {
            // Lẻ: Tổng lập phương
            for (int x : primes) result += (long) x * x * x;
            System.out.println("Stage 2 - Array " + id + ": sum of cubes = " + result);
        }
        return result;
    }
}