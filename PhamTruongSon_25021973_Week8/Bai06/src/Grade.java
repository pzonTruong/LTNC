
public class Grade {
    private double midterm;
    private double finalExam;
    private double assignment;

    public Grade(double midterm, double finalExam, double assignment) {
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.assignment = assignment;
    }

    public double calculateFinalGrade() {
        return assignment * 0.2 + midterm * 0.3 + finalExam * 0.5;
    }

    public String getAcademicStatus() {
        double grade = calculateFinalGrade();
        if (grade >= 8.5)
            return "Giỏi";
        if (grade >= 7.0)
            return "Khá";
        if (grade >= 5.5)
            return "Trung bình";
        return "Yêu";
    }

    // Getters cho việc in ấn
    public double getMidterm() {
        return midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getAssignment() {
        return assignment;
    }
}