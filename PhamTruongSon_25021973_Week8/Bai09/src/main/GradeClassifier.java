package main;

public class GradeClassifier {
    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        if (gpa < 5.0) return "Yếu";
        if (gpa < 6.5) return "Trung bình";
        if (gpa < 8.0) return "Khá";
        return "Giỏi";
    }
}