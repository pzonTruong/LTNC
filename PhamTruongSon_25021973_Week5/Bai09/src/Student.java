import java.io.Serializable;

class Student implements Serializable {
    // serialVersionUID giúp đảm bảo phiên bản lớp khi đọc/ghi đối tượng
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Tên: %-15s | GPA: %.2f", id, name, gpa);
    }
}