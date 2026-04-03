import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập đường dẫn từ bàn phím
        System.out.print("Nhập đường dẫn tệp nguồn (ví dụ: input.txt): ");
        String sourcePath = sc.nextLine();
        System.out.print("Nhập đường dẫn tệp đích (ví dụ: output.txt): ");
        String destPath = sc.nextLine();

        // Khai báo các đối tượng luồng ngoài khối try để có thể đóng trong finally
        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            // Khởi tạo luồng đọc
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file not found.");
            }
            reader = new BufferedReader(new FileReader(sourceFile));

            // Khởi tạo luồng ghi
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            // Đọc từng dòng cho đến khi hết tệp
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }

            System.out.println("Sao chép thành công!");
            System.out.println("Tổng số dòng đã sao chép: " + lineCount);

        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O: I/O error.");
            e.printStackTrace(); // In ngăn xếp lỗi để debug
        } finally {
            // Đảm bảo đóng tệp để giải phóng tài nguyên hệ thống
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                sc.close();
            } catch (IOException e) {
                System.err.println("Lỗi khi đóng tệp: " + e.getMessage());
            }
        }
    }
}