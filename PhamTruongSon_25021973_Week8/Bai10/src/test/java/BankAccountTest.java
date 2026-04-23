import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Khởi tạo tài khoản với số dư 500 trước mỗi test case
        account = new BankAccount("123456", "Nguyen Van A", 500.0);
    }

    // --- TEST DEPOSIT ---

    @Test
    @DisplayName("Nạp tiền hợp lệ")
    void testDepositValid() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance(), "Số dư sau nạp 100 phải là 600");
    }

    @Test
    @DisplayName("Nạp tiền bằng 0 - Kỳ vọng ngoại lệ")
    void testDepositZero() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    @DisplayName("Nạp tiền âm - Kỳ vọng ngoại lệ")
    void testDepositNegative() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    // --- TEST WITHDRAW ---

    @Test
    @DisplayName("Rút tiền trong phạm vi số dư")
    void testWithdrawValid() {
        boolean result = account.withdraw(200.0);
        assertTrue(result);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    @DisplayName("Rút hết sạch số dư (Boundary)")
    void testWithdrawAll() {
        boolean result = account.withdraw(500.0);
        assertTrue(result);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Rút vượt quá số dư")
    void testWithdrawOverBalance() {
        boolean result = account.withdraw(500.01);
        assertFalse(result, "Phải trả về false khi rút quá số dư");
        assertEquals(500.0, account.getBalance(), "Số dư không được thay đổi");
    }

    @Test
    @DisplayName("Rút tiền số âm - Kỳ vọng ngoại lệ")
    void testWithdrawNegative() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1.0));
    }

    // --- TEST TRÌNH TỰ (CONSISTENCY) ---

    @Test
    @DisplayName("Kiểm tra tính nhất quán qua chuỗi giao dịch")
    void testTransactionSequence() {
        // 1. Khởi tạo mới với số dư 0
        BankAccount seqAccount = new BankAccount("999", "Test User");
        assertEquals(0.0, seqAccount.getBalance());

        // 2. Nạp 500
        seqAccount.deposit(500.0);
        assertEquals(500.0, seqAccount.getBalance());

        // 3. Rút 200 (thành công)
        boolean res1 = seqAccount.withdraw(200.0);
        assertTrue(res1);
        assertEquals(300.0, seqAccount.getBalance());

        // 4. Rút 400 (thất bại)
        boolean res2 = seqAccount.withdraw(400.0);
        assertFalse(res2);
        
        // 5. Kiểm tra số dư cuối vẫn phải là 300
        assertEquals(300.0, seqAccount.getBalance(), "Số dư cuối cùng không khớp!");
    }
}