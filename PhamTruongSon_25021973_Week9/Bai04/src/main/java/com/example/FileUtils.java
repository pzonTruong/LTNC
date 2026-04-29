package com.example;

import java.io.File;

public class FileUtils {
    public static String getProjectDataPath(String fileName) {
        return "data" + File.separator + "storage" + File.separator + fileName;
    }
}