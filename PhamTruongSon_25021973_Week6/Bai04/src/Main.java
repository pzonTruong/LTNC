import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adapter parttern demo:");
        int[] data = { 9, 5, 1, 4, 3 };

        // Sử dụng Adapter để gọi thư viện cũ
        LegacySorter oldLibrary = new LegacySorter();
        Sorter sorter = new SorterAdapter(oldLibrary);

        int[] sortedData = sorter.sort(data);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(sortedData));

        System.out.println("\nPrototype pattern demo:");
        // 1. Tạo bản mẫu gốc (Origin)
        ReportTemplate origin = new ReportTemplate("Template Chung", "Copyright 2026");
        origin.addSection("Mục lục");

        // 2. Tạo bản sao 1 và chỉnh sửa
        ReportTemplate reportJan = origin.clone();
        reportJan.setTitle("Report month 01");
        reportJan.addSection("Content month 1");

        // 3. Tạo bản sao 2 và chỉnh sửa
        ReportTemplate reportFeb = origin.clone();
        reportFeb.setTitle("Report month 02");
        reportFeb.addSection("Content month 2");

        // 4. In kết quả để kiểm tra tính độc lập
        System.out.println("Original:  " + origin);
        System.out.println("Copy 1: " + reportJan);
        System.out.println("Copy 2: " + reportFeb);

        System.out.println("\n=> No side effect");
    }
}