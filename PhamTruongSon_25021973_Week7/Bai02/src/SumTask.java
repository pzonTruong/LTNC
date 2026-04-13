import java.util.concurrent.Callable;

/**
 * Lớp SumTask thực hiện tính tổng một phân đoạn của mảng.
 * Sử dụng Callable để có thể trả về kết quả sau khi kết thúc.
 */
public class SumTask implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        // Tính tổng trong phạm vi [start, end)
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}