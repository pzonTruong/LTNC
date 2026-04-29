package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ShippingCalculatorTest {

    ShippingCalculator calc = new ShippingCalculator();

    @Test
    void testStandard() {
        assertEquals(15000.0, calc.calculate(5, "STANDARD"));
    }

    @Test
    void testExpress() {
        assertEquals(45000.0, calc.calculate(5, "EXPRESS"));
    }

    @Test
    void testInvalidWeight() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calculate(-1, "STANDARD"));
    }

    //Lỗi 4 (Tự tạo): Lỗ hổng Edge Case gây NullPointerException
    @Test
    void testNullTypeHandling() {
        // Kỳ vọng hệ thống báo lỗi tham số không hợp lệ khi truyền null
        assertThrows(IllegalArgumentException.class,
            () -> calc.calculate(5, null));
    }

    //Khi type mang giá trị null, hệ thống cố gắng gọi phương thức .equals() từ một vùng nhớ không tồn tại, 
    // gây ra lỗi NullPointerException (NPE) ở cấp độ JVM và làm sập tiến trình, thay vì xử lý ngoại lệ nghiệp vụ một cách an toàn.
}

