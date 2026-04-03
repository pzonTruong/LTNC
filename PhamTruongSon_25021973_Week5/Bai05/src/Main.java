
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // Dữ liệu mẫu
        Book b1 = new Book("B001", "Java Programming", "John Smith", 2020);
        Book b2 = new Book("B003", "Python Basics", "Alice Wong", 2021);
        Book b3 = new Book("B002", "Data Structures", "Bob Lee", 2019);
        Book b4 = new Book("B005", "AI Intro", "Sarah J.", 2023);
        Book b5 = new Book("B004", "Clean Code", "Uncle Bob", 2008);

        // --- CÁCH 1: ARRAYLIST --- (Cách bình thường)
        System.out.println("\n=== QUẢN LÝ BẰNG ARRAYLIST ===");
        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);

        // Tìm kiếm (Phải duyệt vòng lặp)
        for (Book b : list) {
            if (b.getId().equals("B003")) {
                System.out.println("Tìm thấy: " + b);
            }
        }

        // Xóa
        list.removeIf(b -> b.getId().equals("B001"));
        list.forEach(System.out::println);

        // --- CÁCH 2: HASHMAP --- (Tốc độ cao do không phải duyệt từng phần tử)
        System.out.println("\n=== QUẢN LÝ BẰNG HASHMAP ===");
        Map<String, Book> hashMap = new HashMap<>();
        hashMap.put(b1.getId(), b1);
        hashMap.put(b2.getId(), b2);
        hashMap.put(b3.getId(), b3);
        hashMap.put(b4.getId(), b4);
        hashMap.put(b5.getId(), b5);

        System.out.println("Tìm B003: " + hashMap.get("B003"));
        hashMap.remove("B001");
        hashMap.values().forEach(System.out::println);

        // --- CÁCH 3: TREEMAP --- (Tự động sắp xếp ID)
        System.out.println("\n=== QUẢN LÝ BẰNG TREEMAP ===");
        Map<String, Book> treeMap = new TreeMap<>();
        treeMap.put(b1.getId(), b1);
        treeMap.put(b2.getId(), b2);
        treeMap.put(b3.getId(), b3);
        treeMap.put(b4.getId(), b4);
        treeMap.put(b5.getId(), b5);

        System.out.println("Tìm B003: " + treeMap.get("B003"));
        treeMap.remove("B001");
        // In ra sẽ thấy ID được sắp xếp: B002, B003, B004, B005
        treeMap.values().forEach(System.out::println);
    }
}
