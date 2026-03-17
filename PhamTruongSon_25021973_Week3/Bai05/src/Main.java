
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");

            // Xử lý tách loại NV và Tên dựa trên dấu ngoặc kép
            String type = parts[0].trim(); // F hoặc P
            String name = parts[1];        // Nội dung trong dấu ""
            String remain = parts[2].trim(); // Các con số còn lại
            String[] stats = remain.split("\\s+");

            if (type.equalsIgnoreCase("F")) {
                double base = Double.parseDouble(stats[0]);
                double bonus = Double.parseDouble(stats[1]);
                double penalty = Double.parseDouble(stats[2]);

                employees[i] = new FullTimeEmployee(name, base, bonus, penalty);
            } else if (type.equalsIgnoreCase("P")) {
                int hours = Integer.parseInt(stats[0]);
                double rate = Double.parseDouble(stats[1]);
                
                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }

        System.out.println("\n--- BẢNG LƯƠNG CHI TIẾT ---");
        for (Employee emp : employees) {
            System.out.printf("%s - %s - %.1f\n",
                    emp.getName(), emp.getEmployeeType(), emp.calculateSalary());
        }

        sc.close();
    }
}
