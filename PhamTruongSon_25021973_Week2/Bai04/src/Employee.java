public class Employee {
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(Employee other){
        this.name = other.name;
        this.birthday = new MyDate(other.birthday); // Deep copy: tạo đối tượng mới
        // Shallow copy; this.birthday = other.birthday;
    }

    public String getName() { return name; }
    public MyDate getBirthday() { return birthday; }

    @Override
    public String toString(){
        return "Employee: " + name + "- Date: " + birthday.toString();
    }
}
