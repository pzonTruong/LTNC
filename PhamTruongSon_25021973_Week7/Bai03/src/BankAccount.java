/**
 * Lớp đại diện cho tài khoản ngân hàng.
 * Các phương thức được đánh dấu 'synchronized' để đảm bảo tính Thread-safe.
 */
public class BankAccount {
    private int balance = 0;

    // Synchronized đảm bảo luồng này xong thì luồng kia mới được vào
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        // Có thể thêm kiểm tra balance >= amount nếu muốn logic thực tế hơn
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}