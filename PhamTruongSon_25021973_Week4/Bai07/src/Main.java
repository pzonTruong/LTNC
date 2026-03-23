
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // Nhập dữ liệu mẫu
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.next(), sc.nextDouble()));
        }

        // 1.
        students.removeIf(s -> s.getGpa() < 5.0);

        System.out.println("\nAfter removing GPA < 5.0:");
        students.forEach(System.out::println);

        // 2.
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("\nAfter sorting by name:");
        students.forEach(System.out::println);

        // 3.
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> b != 0 ? a / b : 0.0;

        System.out.println("\nCalculations using Lambda:");
        System.out.println("10 + 5 = " + add.execute(10.0, 5.0));
        System.out.println("10 * 5 = " + multiply.execute(10.0, 5.0));
        System.out.println("10 - 5 = " + subtract.execute(10.0, 5.0));
        System.out.println("10 / 5 = " + divide.execute(10.0, 5.0));
    }
}
