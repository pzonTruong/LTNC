
public class Student {

    // Encap
    private int id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
        this(0, "None", "none@gmail.com", 0.0);
    }

    public Student(int id, String name) {
        this(id, name, "none@gmail.com", 0.0);
    }

    public Student(Student other) {
        this(other.id, other.name, other.email, other.gpa);
    }

    public Student(int id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.setGpa(gpa); // setter
    }

    // Validation
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
            System.out.println("Success setGpa(), GPA: " + gpa);
        } else {
            System.out.println("Error in setGpa(), GPA: " + gpa);
        }
    }

    public String info() {
        return "ID: " + id + "|Name: " + name + "| GPA: " + gpa;
    }
}
