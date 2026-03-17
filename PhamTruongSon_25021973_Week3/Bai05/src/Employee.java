
abstract class Employee {

    protected String name;

    // constructor
    public Employee(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // Phương thức trừu tượng để các lớp con tự định nghĩa logic
    public abstract double calculateSalary();

    public abstract String getEmployeeType();
}
