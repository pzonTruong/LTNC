public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Luồng A: Thực hiện nạp tiền 1000 lần
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100);
            }
        });

        // Luồng B: Thực hiện rút tiền 1000 lần
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(100);
            }
        });

        // Bắt đầu chạy
        threadA.start();
        threadB.start();

        try {
            // Đợi cả 2 hoàn thành
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kết quả kỳ vọng: 0 (vì nạp 1000*100 và rút 1000*100)
        System.out.println("Final balance: " + account.getBalance());
    }
}