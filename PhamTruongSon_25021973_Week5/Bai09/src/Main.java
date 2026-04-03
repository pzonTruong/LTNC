import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "students.obj";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        // --- PHẦN 1: NHẬP VÀ GHI DỮ LIỆU ---
        System.out.println("--- NHẬP DANH SÁCH SINH VIÊN (Nhập 'END' tại ID để dừng) ---");
        while (true) {
            System.out.print("Nhập ID: ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) break; // Kiểm tra điều kiện dừng

            System.out.print("Nhập tên: ");
            String name = sc.nextLine(); 
            System.out.print("Nhập GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            studentList.add(new Student(id, name, gpa));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList); // Ghi nguyên cả List đối tượng
            System.out.println("\nĐã lưu danh sách vào tệp " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }

        // --- PHẦN 2: ĐỌC VÀ HIỂN THỊ DỮ LIỆU ---
        System.out.println("\n--- ĐỌC DANH SÁCH TỪ TỆP ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            
            // Ép kiểu dữ liệu đọc được về List<Student>
            List<Student> savedList = (List<Student>) ois.readObject();
            
            for (Student s : savedList) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp dữ liệu.");
        } catch (EOFException e) {
            System.out.println("Đã đọc hết nội dung tệp.");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy định nghĩa lớp Student.");
        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}