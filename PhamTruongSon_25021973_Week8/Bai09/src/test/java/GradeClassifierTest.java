import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    @Test
    void testYeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
    }

    @Test
    void testTrungBinh() {
        // Case này dễ bị FAIL do code gốc gpa <= 5.0 trả về "Yếu"
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }

    @Test
    void testKha() {
        // Case này dễ bị FAIL do code gốc gpa <= 6.5 trả về "Trung bình"
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
        assertEquals("Khá", GradeClassifier.classifyGrade(7.5));
    }

    @Test
    void testGioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    void testInvalidGPA() {
        // Kiểm tra ngoại lệ cho -0.1
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-0.1);
        });
        assertTrue(ex1.getMessage().contains("GPA không hợp lệ: -0.1"));

        // Kiểm tra ngoại lệ cho 10.1
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.1);
        });
        assertTrue(ex2.getMessage().contains("GPA không hợp lệ: 10.1"));
    }
}