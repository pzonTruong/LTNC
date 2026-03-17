
public class PartTimeEmployee extends Employee {

    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, int workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getEmployeeType() {
        return "Part-time";
    }
}
