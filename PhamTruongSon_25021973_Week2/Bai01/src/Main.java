public static void main(String[] args){
    BankAccount acc = new BankAccount("SSB", "Pham Son", 100);
    System.out.println("Remain balance: " + acc.getBalance());

    acc.deposit(-200);

    acc.deposit(200);
    acc.withdraw(1000);

    boolean check = acc.withdraw(150);
    if (check) {
        System.out.println("Correct");
    }
}