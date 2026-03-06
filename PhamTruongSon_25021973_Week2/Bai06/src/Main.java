public class Main{
    public static void main(String[] args){
        Account myAcc = new Account("ID1", 1000.0);
        myAcc.addTransaction(new Transaction("T1",100.0,"11:00"));
        myAcc.addTransaction(new Transaction("T2",200.0,"12:00"));

        System.out.println("Testing");
        Transaction[] stolen = myAcc.getHistory();

        stolen[0] = null; // Ko dc
        // stolen[1].amount = 9999999; -> Khong dc
        myAcc.displayHistory();

        if (myAcc.getHistory()[0] != null){
            System.out.println("Data is still safe");
        }
    }
}