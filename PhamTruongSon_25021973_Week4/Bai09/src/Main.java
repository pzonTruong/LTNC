
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // // 1. Tạo kho thực phẩm (Chỉ nhận đối tượng Food)
        // Warehouse<Food> foodStorage = new Warehouse<>("Kho Lạnh");
        // foodStorage.addProduct(new Food("F01", "Sữa tươi", "20/12/2026"));
        // foodStorage.addProduct(new Food("F02", "Thịt bò", "15/04/2026"));
        // // 2. Tạo kho điện tử (Chỉ nhận đối tượng Electronic)
        // Warehouse<Electronic> techStorage = new Warehouse<>("Kho Linh Kiện");
        // techStorage.addProduct(new Electronic("E01", "Tivi Sony", 24));
        // techStorage.addProduct(new Electronic("E02", "Laptop Dell", 12));
        // // 3. Kiểm kê
        // foodStorage.showInventory();
        // techStorage.showInventory();
        // // 4. THỬ NGHIỆM LỖI (Bỏ comment để xem lỗi biên dịch)
        // // Warehouse<String> stringWarehouse; // LỖI: String không kế thừa Product
        // // foodStorage.addProduct(new Electronic("E03", "Máy giặt", 12)); // LỖI: Kho Food không nhận Electronic
        
        Scanner sc = new Scanner(System.in);
        Warehouse<Food> foodStorage = new Warehouse<>("Kho Lạnh");
        Warehouse<Electronic> techStorage = new Warehouse<>("Kho Linh Kiện");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            String date = sc.next();

            switch (type) {
                case "F" ->
                    foodStorage.addProduct(new Food(id, name, date));
                case "E" ->
                    techStorage.addProduct(new Electronic(id, name, Integer.parseInt(date)));
            }
        }

        foodStorage.showInventory();
        techStorage.showInventory();

    }
}
