import java.util.concurrent.Callable;

public class PrimeCountTask implements Callable<Integer> {
    private final int id;
    private final int[] array;

    public PrimeCountTask(int id, int[] array) {
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
    public Integer call() {
        int count = 0;
        for (int x : array) {
            if (isPrime(x)) count++;
        }
        return count;
    }
}