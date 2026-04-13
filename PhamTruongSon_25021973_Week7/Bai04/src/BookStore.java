import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class BookStore {
    private final Map<String, Integer> stock = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    // Khóa đọc: Cho phép nhiều luồng đọc cùng lúc
    private final Lock readLock = rwLock.readLock();
    // Khóa ghi: Chỉ cho phép một luồng ghi duy nhất
    private final Lock writeLock = rwLock.writeLock();

    public void addBook(String title, int qty) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " dang NHAP sach: " + title);
            stock.put(title, stock.getOrDefault(title, 0) + qty);
            Thread.sleep(500); // Mô phỏng thời gian xử lý
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void borrow(String title, int qty) {
        writeLock.lock();
        try {
            int current = stock.getOrDefault(title, 0);
            if (current >= qty) {
                System.out.println(Thread.currentThread().getName() + " dang MUON sach: " + title);
                stock.put(title, current - qty);
            } else {
                System.out.println(Thread.currentThread().getName() + " khong du sach de muon!");
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void getStock(String title) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " dang DOC: " + title + " - Ton kho: " + stock.getOrDefault(title, 0));
            Thread.sleep(200); // Các luồng đọc sẽ chạy song song đoạn này
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}