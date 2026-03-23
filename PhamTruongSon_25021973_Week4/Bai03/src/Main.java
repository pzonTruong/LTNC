
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();

            if (type.equals("O")) {
                list.add(new OfficeWorker(id, name, baseSalary));
            } else if (type.equals("T")) {
                int ot = sc.nextInt();
                list.add(new Technician(id, name, baseSalary, ot));
            }
        }

        double totalPay = 0;
        System.out.println(); // In dòng trống cho đẹp

        for (Employee e : list) {
            double pay = e.calculatePay();
            totalPay += pay;

            System.out.println(e.name + " - Pay: " + pay);
            e.work();
            System.out.println();
        }

        System.out.println("Total Pay = " + totalPay);
    }
}
