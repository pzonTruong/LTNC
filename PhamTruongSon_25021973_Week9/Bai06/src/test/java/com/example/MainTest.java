package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class MainTest {
    Main app = new Main();

    @Test
    void testPathCrossPlatform() {
        String result = app.getSafePath("user", "data");
        // Kiểm tra xem đường dẫn có chứa dấu phân cách đúng của HĐH không
        assertTrue(result.contains(File.separator));
        assertTrue(result.startsWith("root"));
    }

    @Test
    void testAdd() {
        assertEquals(5, app.add(2, 3));
    }
}