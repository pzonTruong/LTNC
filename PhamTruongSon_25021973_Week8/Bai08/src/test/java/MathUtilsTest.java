import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @BeforeAll
    public static void setup() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("=== Kết thúc ===");
    }

    // --- TEST CASES FOR max(a, b) ---

    @Test
    @DisplayName("EP: Test case a > b")
    void testMaxAFirst() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    @DisplayName("EP: Test case a < b")
    void testMaxBFirst() {
        assertEquals(20, MathUtils.max(5, 20));
    }

    @Test
    @DisplayName("EP: Test case a = b")
    void testMaxEqual() {
        assertEquals(7, MathUtils.max(7, 7));
    }

    @Test
    @DisplayName("BVA: Test case với Integer.MAX_VALUE")
    void testMaxBoundaryMax() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 100));
    }

    @Test
    @DisplayName("BVA: Test case với Integer.MIN_VALUE")
    void testMaxBoundaryMin() {
        assertEquals(-1, MathUtils.max(Integer.MIN_VALUE, -1));
    }

    // --- TEST CASES FOR divide(a, b) ---

    @Test
    @DisplayName("EP: Test case b > 0")
    void testDividePositive() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    @DisplayName("EP: Test case b < 0")
    void testDivideNegative() {
        assertEquals(-3, MathUtils.divide(9, -3));
    }

    @Test
    @DisplayName("EP: Test case b = 0 (Expect Exception)")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}