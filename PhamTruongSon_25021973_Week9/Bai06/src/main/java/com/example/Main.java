package com.example;

import java.nio.file.Paths;

public class Main {
    public String getSafePath(String... parts) {
        if (parts == null || parts.length == 0) {
            return "";
        }
        return Paths.get("root", parts).toString();
    }

    public int add(int a, int b) {
        return a + b;
    }
}