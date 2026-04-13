import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Stage1Task implements Callable<List<Integer>> {
    private final int id;
    private final int[] array;

    public Stage1Task(int id, int[] array) {
        this.id = id;
        this.array = array;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();
        for (int x : array) {
            if (isPrime(x)) primes.add(x);
        }
        System.out.println("Stage 1 - Array " + id + ": " + primes);
        return primes;
    }
}