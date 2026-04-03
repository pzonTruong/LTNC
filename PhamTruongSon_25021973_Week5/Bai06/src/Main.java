import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên thứ nhất (a): ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên thứ hai (b): ");
            int b = scanner.nextInt();

            // Thực hiện phép chia
            int result = a / b;
            System.out.println("Kết quả phép chia " + a + " / " + b + " = " + result);

        } catch (InputMismatchException e) {
            // Lỗi khi người dùng nhập chữ thay vì số
            System.out.println("Lỗi: Bạn phải nhập vào một số nguyên!");
        } catch (ArithmeticException e) {
            // Lỗi khi thực hiện phép toán vô lý (chia cho 0)
            System.out.println("Lỗi: Không thể thực hiện phép chia cho 0.");
        } catch (Exception e) {
            // Bắt các lỗi không xác định khác (nếu có)
            System.out.println("Đã xảy ra lỗi không mong muốn: " + e.getMessage());
        } finally {
            // Khối này luôn chạy dù có lỗi hay không
            System.out.println("Program finished.");
            scanner.close(); // Đóng tài nguyên
        }
    }
}