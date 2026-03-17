import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);


            if (type.equalsIgnoreCase("E")){
                list.add(new Employee(name, salary));
            } else if (type.equalsIgnoreCase("D")){
                int hours = Integer.parseInt(parts[3]);
                list.add(new Developer(name, salary, hours));
            } else if (type.equalsIgnoreCase("T")){
                int bugs = Integer.parseInt(parts[3]);
                list.add(new Tester(name, salary, bugs));
            }
        }

        System.out.println("\n---OUTPUT---");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - Bonus: " + emp.calculateBonus());

            // Phần nâng cao: Kiểm tra kiểu đối tượng
            if (emp instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (emp instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
            
            System.out.println(); // Dòng trống ngăn cách các nhân viên
        }

        sc.close();
    }
}
