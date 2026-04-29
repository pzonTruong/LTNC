package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class PathManagerTest {
    PathManager manager = new PathManager();

    @Test
    void testValidPath() {
        String result = manager.getStoragePath("uploads", "test.txt");
        assertTrue(result.contains("data"));
        assertTrue(result.contains(File.separator));
    }

    @Test
    void testNullInput() {
        assertEquals("", manager.getStoragePath(null, null));
    }
}