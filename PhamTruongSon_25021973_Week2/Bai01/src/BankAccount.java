public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    // constructor
    public BankAccount(String accountNumber, String ownerName){
        this(accountNumber, ownerName, 0);
    }

    public BankAccount(String accountNumber, String ownerName, double initBalance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initBalance < 0){
            System.out.println("Error in constructor: Balance < 0");
            this.balance = 0;
        }else{
            this.balance = initBalance;
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("Add: +" + amount);
        } else {
            System.out.println("Error in deposit: Amount must be positive");
        }
    }

    public boolean withdraw(double amount){
        if (amount > this.balance || amount <= 0){
            System.out.println("Error in withdraw: Invalid amount");
            return false;
        }else{
            this.balance -= amount;
            System.out.println("Withdraw successfully");
            return true;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
}
