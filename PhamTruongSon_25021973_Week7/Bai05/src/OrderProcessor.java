import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor implements Callable<Boolean> {
    private final String id;
    private final long processMs;
    private final List<String> logs;
    private final AtomicInteger successCounter;

    public OrderProcessor(String id, long processMs, List<String> logs, AtomicInteger successCounter) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCounter = successCounter;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Start " + id);
        
        // Mô phỏng thời gian xử lý
        Thread.sleep(processMs);

        boolean isSuccess = processMs <= 1500;
        String status = isSuccess ? "DONE " : "FAIL ";
        
        // Ghi log đồng bộ (vì nhiều luồng cùng ghi vào một List)
        synchronized (logs) {
            logs.add(status + id);
        }

        if (isSuccess) {
            // Tăng biến đếm an toàn luồng mà không cần synchronized
            successCounter.incrementAndGet();
        }

        return isSuccess;
    }
}