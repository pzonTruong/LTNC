package com.example;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    @Test
    void testFilePathFormat() {
        String path = FileUtils.getProjectDataPath("config.json");
        System.out.println("Testing path: " + path);
        
        // Kiểm tra xem đường dẫn có hợp lệ với hệ thống hiện tại không
        File file = new File(path);
        // Trên Linux/macOS, File(path) với dấu \ sẽ coi nguyên chuỗi là tên file thay vì thư mục
        assertTrue(path.contains(File.separator), "Path should use the correct system separator");
    }
}