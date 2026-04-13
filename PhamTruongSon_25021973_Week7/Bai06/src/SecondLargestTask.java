import java.util.concurrent.Callable;

public class SecondLargestTask implements Callable<Integer> {
    private final int[] array;
    private final int id;

    public SecondLargestTask(int id, int[] array) {
        this.id = id;
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        if (array == null || array.length < 2) {
            throw new Exception("Array " + id + ": Not found");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int x : array) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second && x != first) {
                second = x;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new Exception("Array " + id + ": Not found");
        }

        System.out.println("Array " + id + ": second largest = " + second);
        return second;
    }
}