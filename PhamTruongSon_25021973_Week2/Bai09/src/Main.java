import java.util.Scanner;

public class Main{
    public static void main(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tên: "); String name1 = sc.nextLine();
        System.out.print("Giá: "); double price1 = sc.nextDouble();
        System.out.print("Số lượng kho: "); int qty1 = sc.nextInt();
        System.out.print("Giảm giá: "); double disc1 = sc.nextDouble();
        Product p1 = new Product(name1, price1, qty1, disc1);

        sc.nextLine(); // Đọc bỏ dòng trống

        System.out.print("Tên: "); String name2 = sc.nextLine();
        System.out.print("Giá: "); double price2 = sc.nextDouble();
        System.out.print("Số lượng kho: "); int qty2 = sc.nextInt();
        System.out.print("Giảm giá: "); double disc2 = sc.nextDouble();
        Product p2 = new Product(name2, price2, qty2, disc2);

        System.out.print("\nNhập số lượng p1 cần mua: ");
        p1.sell(sc.nextInt());
        System.out.print("Nhập số lượng p2 cần mua: ");
        p2.sell(sc.nextInt());

        // KIỂM TRA TÍNH CHẤT STATIC
        System.out.println("\n--- Kiểm tra giá ban đầu (Thuế 10%) ---");
        System.out.println("P1 Final Price: " + p1.calculateFinalPrice());
        System.out.println("P2 Final Price: " + p2.calculateFinalPrice());

        // 1. Thay đổi Static Field (Thuế)
        Product.updateTaxRate(0.08);
        System.out.println("Sau khi giảm thuế xuống 8%:");
        System.out.println("P1 Final Price: " + p1.calculateFinalPrice());
        System.out.println("P2 Final Price: " + p2.calculateFinalPrice());
        System.out.println("=> Nhận xét: Cả p1 và p2 đều đổi giá theo thuế mới.");

        // 2. Thay đổi Instance Field (Giảm giá riêng của p1)
        p1.updateDiscount(10.0);
        System.out.println("\nSau khi thay đổi giảm giá riêng của P1:");
        System.out.println("P1 Final Price: " + p1.calculateFinalPrice());
        System.out.println("P2 Final Price: " + p2.calculateFinalPrice());
        System.out.println("=> Nhận xét: Chỉ p1 đổi giá, p2 giữ nguyên.");

        // 3. In tổng doanh thu
        System.out.println("\nTổng doanh thu toàn hệ thống: " + Product.getTotalRevenue());

        sc.close();
    }
}