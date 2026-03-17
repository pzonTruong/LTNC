public class Employee extends Person{
    private double salary;
    public Employee(String name){
        super(name);
        System.err.println("2. Employee is created");
    }
}
