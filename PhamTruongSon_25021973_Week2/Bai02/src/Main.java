
public class Main {

    public static void main(String[] args) {
        System.out.println("--STARTING--");
        Student stu1 = new Student();
        Student stu2 = new Student(2, "Pzon");
        Student stu3 = new Student(3, "Pham Son", "hello@gmail.com", -2.0);

        stu2.setGpa(5.5);
        stu3.setGpa(2.5);

        System.out.println(stu1.info());
        System.out.println(stu2.info());
        System.out.println(stu3.info());
    }
}
