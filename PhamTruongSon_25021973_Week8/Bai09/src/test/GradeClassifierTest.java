package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; // Thêm dòng này để dùng assertEquals trực tiếp
import main.GradeClassifier;

public class GradeClassifierTest {
    @Test
    void testGrade() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(2.5));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }
}