
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> order = new ArrayList<>();

        System.out.println("Nhập số lượng sản phẩm");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String name = parts[1];
            String[] stats = parts[2].trim().split("\\s+");

            if (type.equalsIgnoreCase("E")) {
                double price = Double.parseDouble(stats[0]);
                double warranty = Double.parseDouble(stats[1]);

                order.add(new Electronics(name, price, warranty));
            } else if (type.equalsIgnoreCase("F")) {
                double price = Double.parseDouble(stats[0]);
                LocalDate expiry = LocalDate.parse(stats[1]); // Định dạng YYYY-MM-DD
                order.add(new Food(name, price, expiry));
            }
        }

        System.out.println("\n--- CHI TIẾT ĐƠN HÀNG ---");
        double total = 0;
        for (Product p : order) {
            double finalPrice = p.getFinalPrice();
            System.out.printf("%s - %s - %.1f\n", p.getName(), p.getItemType(), finalPrice);
            total += finalPrice;
        }
        System.out.println("--------------------------");
        System.out.println("Total = " + total);

        sc.close();
    }
}
