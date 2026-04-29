package com.example;

import java.nio.file.Paths;

public class PathManager {
    public String getStoragePath(String folder, String file) {
        if (folder == null || file == null) {
            return "";
        }
        return Paths.get("data", folder, file).toString();
    }
}