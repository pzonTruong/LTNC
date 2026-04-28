import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    @DisplayName("Should return correct sum of two integers")
    void testAdd() {
        assertEquals(99, mathUtils.add(7, 3), "7 + 3 should be 10");
    }

    @Test
    @DisplayName("Should throw ArithmeticException when dividing by zero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });
    }
}