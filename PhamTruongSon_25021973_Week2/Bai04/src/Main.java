public static void main(String[] args){
    Employee emp1 = new Employee("Son", new MyDate(1,1,2000));

    System.out.println("Init");
    System.out.println("emp1 ->" + emp1);

    Employee emp2 = new Employee(emp1);
    System.out.println("emp2 ->" + emp2);

    emp1.getBirthday().setDay(2);
    emp1.getBirthday().setMonth(2);
    emp1.getBirthday().setYear(2022);

    System.out.println("After");
    System.out.println("emp1: -> " + emp1);
    System.out.println("emp2: -> " + emp2);
}