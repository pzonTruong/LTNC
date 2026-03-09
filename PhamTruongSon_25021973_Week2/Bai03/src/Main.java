
public class Main {

    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);

        n1.swap(n2);
        System.out.println("N1: " + n1.getValue());
        System.out.println("N2: " + n2.getValue());
    }
}
