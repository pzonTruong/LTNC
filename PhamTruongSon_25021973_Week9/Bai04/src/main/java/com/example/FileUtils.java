package com.example;

import java.nio.file.Path;

public class FileUtils {
    public static String getProjectDataPath(String fileName) {
        return Path.of("data", "storage", fileName).toString();
    }
}