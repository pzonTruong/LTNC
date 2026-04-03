import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập tên tệp để ghi: ");
        String fileName = sc.nextLine();
        
        System.out.print("Bạn muốn nhập bao nhiêu số? ");
        int n = sc.nextInt();

        // Sử dụng Try-with-resources để tự động đóng luồng
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int num = sc.nextInt();
                dos.writeInt(num); // Ghi số nguyên dạng nhị phân (4 bytes)
            }
            System.out.println("Đã ghi dữ liệu thành công vào " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }

        sc.close();
    }
}