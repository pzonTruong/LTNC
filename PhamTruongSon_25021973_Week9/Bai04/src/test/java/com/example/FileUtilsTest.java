package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;

public class FileUtilsTest {

    @Test
    public void testGetProjectDataPath() {
        String fileName = "config.json";
        String expected = "data" + File.separator + "storage" + File.separator + fileName;
        String actual = FileUtils.getProjectDataPath(fileName);
        
        assertEquals(expected, actual, "Path should be constructed using the system's file separator");
    }
}