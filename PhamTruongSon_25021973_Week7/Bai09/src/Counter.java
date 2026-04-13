import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Counter {
    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        // Cách dùng lock cơ bản: đợi cho đến khi lấy được
        lock.lock();
        try {
            value++;
        } finally {
            // Luôn mở khóa trong khối finally
            lock.unlock();
        }
    }

    public void incrementWithTryLock() {
        try {
            // Thử lấy lock trong vòng 100ms, nếu không được thì bỏ qua
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    value++;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": Khong lay duoc lock, bo qua luot nay.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getValue() {
        return value;
    }
}