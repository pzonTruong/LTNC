import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculatorTest {

    // --- TEST EQUIVALENCE PARTITIONING (EP) ---

    @Test
    @DisplayName("TC01: Price âm -> Exception")
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount(-10.0, "MEMBER"));
    }

    @Test
    @DisplayName("TC02: Member không hợp lệ -> Exception")
    void testInvalidMember() {
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount(150.0, "GOLD"));
    }

    @Test
    @DisplayName("TC03: GUEST không có chiết khấu")
    void testGuestDiscount() {
        assertEquals(0.0, DiscountCalculator.calculateDiscount(50.0, "GUEST"));
        assertEquals(0.0, DiscountCalculator.calculateDiscount(150.0, "GUEST"));
    }

    // --- TEST BOUNDARY VALUE ANALYSIS (BVA) ---

    @Nested
    @DisplayName("Kiểm tra ranh giới Price = 100")
    class BoundaryPrice100 {
        @Test
        void testMemberBoundary() {
            // Dưới 100: 5%
            assertEquals(4.9995, DiscountCalculator.calculateDiscount(99.99, "MEMBER"), 0.0001);
            // Từ 100: 10%
            assertEquals(10.0, DiscountCalculator.calculateDiscount(100.0, "MEMBER"));
        }

        @Test
        void testVipBoundary() {
            // Dưới 100: 15%
            assertEquals(14.9985, DiscountCalculator.calculateDiscount(99.99, "VIP"), 0.0001);
            // Từ 100: 20%
            assertEquals(20.0, DiscountCalculator.calculateDiscount(100.0, "VIP"));
        }
    }

    @Test
    @DisplayName("Kiểm tra ranh giới Price = 0")
    void testPriceZero() {
        // min- (-0.01)
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount(-0.01, "MEMBER"));
        // min (0.0)
        assertEquals(0.0, DiscountCalculator.calculateDiscount(0.0, "VIP"));
    }

    // --- 2-WAY COMBINATORIAL TESTING (Mẫu một số cặp quan trọng) ---

    @Test
    @DisplayName("Combinatorial: Member x Price >= 100")
    void testMemberHighPrice() {
        assertEquals(15.0, DiscountCalculator.calculateDiscount(150.0, "MEMBER"));
    }

    @Test
    @DisplayName("Combinatorial: VIP x Price < 100")
    void testVipLowPrice() {
        assertEquals(7.5, DiscountCalculator.calculateDiscount(50.0, "VIP"));
    }
}