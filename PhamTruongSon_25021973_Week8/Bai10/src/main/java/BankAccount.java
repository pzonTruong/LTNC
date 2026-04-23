public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    // Constructor mặc định số dư là 0.0
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Constructor có số dư ban đầu
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            System.err.println("Số dư ban đầu không hợp lệ. Gán mặc định là 0.");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    /**
     * Nạp tiền vào tài khoản.
     * @param amount Số tiền cần nạp (phải > 0)
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0.");
        }
        this.balance += amount;
    }

    /**
     * Rút tiền từ tài khoản.
     * @param amount Số tiền cần rút (phải > 0 và <= số dư)
     * @return true nếu rút thành công, false nếu số dư không đủ
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0.");
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}