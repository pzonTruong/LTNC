public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private int balance;

    // constructor
    public BankAccount(String accountNumber, String ownerName){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String ownerName, int initBalance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initBalance < 0){
            System.out.println("Error: Số dư nhỏ hơn 0");
            this.balance = 0;
        }else{
            this.balance = initBalance;
        }
    }

    public void deposit(int amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("Add: +" + amount);
        } else {
            System.out.println("Error: Need more than 0");
        }
    }

    public boolean withdraw(int amount){
        if (amount > this.balance){
            System.out.println("Not enough balance");
            return false;
        }else{
            this.balance -= amount;
            System.out.println("Withdraw sucessfully");
            return true;
        }
    }

    public int getBalance(){
        return this.balance;
    }
}
