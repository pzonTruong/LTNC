package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MathUtilsTest {

    @BeforeAll
    static void initAll() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("=== Kết thúc ===");
    }

    @Test
    @DisplayName("Test hàm max: a > b")
    void testMax() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    @DisplayName("Test hàm divide: chia cho 0")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.divide(10, 0));
    }
}