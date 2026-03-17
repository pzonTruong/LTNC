
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<IPayable> payableList = new ArrayList<>();

        System.out.print("Nhập số đối tượng: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String type = parts[0];

            if (type.equalsIgnoreCase("S")) {
                // S [id] [name] [hours] [rate]
                String id = parts[1];
                String name = parts[2];
                int hours = Integer.parseInt(parts[3]);
                double rate = Double.parseDouble(parts[4]);
                payableList.add(new PartTimeStaff(id, name, hours, rate));
            } else if (type.equalsIgnoreCase("I")) {
                // I [itemName] [quantity] [price]
                String itemName = parts[1];
                int qty = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);
                payableList.add(new Invoice(itemName, qty, price));
            }
        }

        System.out.println("\n--- CHI TIẾT THANH TOÁN ---");
        double total = 0;
        for (IPayable item : payableList) {
            System.out.println(item.toString());
            total += item.getPaymentAmount();
        }

        System.out.println("---------------------------");
        System.out.println("Total Payment = " + total);

        sc.close();
    }
}
