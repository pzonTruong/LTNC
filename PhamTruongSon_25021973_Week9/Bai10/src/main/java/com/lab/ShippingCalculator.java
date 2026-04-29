package com.lab;

public class ShippingCalculator {

    public double calculate(double weight, String type) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        // Kỹ thuật Yoda condition: "EXPRESS" luôn khác null, nên gọi .equals() sẽ an
        // toàn
        // Nếu type là null, nó chỉ đơn giản trả về false.
        if ("EXPRESS".equals(type))
            return weight * 5000 + 20000;
        if ("STANDARD".equals(type))
            return weight * 3000;

        throw new IllegalArgumentException("Unknown type: " + type);
    }
}