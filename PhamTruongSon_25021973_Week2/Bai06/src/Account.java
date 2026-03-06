import java.util.Arrays;

public class Account
{
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int transactionCount;

    public Account(String id, double initialBalance){
        this.accountId = id;
        this.balance = initialBalance;
        this.history = new Transaction[10];
    }

    public void addTransaction(Transaction t){
        if(transactionCount < history.length){
            history[transactionCount++] = t;
        }
    }

    public Transaction[] getHistory(){
        return Arrays.copyOf(this.history, this.transactionCount);
    }

    public void displayHistory() {
        System.out.println("History:");
        for(int i=0; i<transactionCount; i++){
            System.out.println(history[i]);
        }
    }
}
