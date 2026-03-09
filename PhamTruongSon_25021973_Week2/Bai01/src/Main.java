
public class Main {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("SSB", "Pham Son", 100.0);
        System.out.println("Remain balance: " + acc.getBalance());

        // Nap tien am
        acc.deposit(-200);

        // Rut qua so du
        acc.deposit(200);
        acc.withdraw(1000);

        // Rut hop le
        boolean check = acc.withdraw(150);
        if (check) {
            System.out.println("Correct test case.");
        }
    }
}
