public class C {
    // public double getArea(String shapeType, double a, double b) {
    // if (shapeType.equals("rectangle"))
    // return a * b;
    // if (shapeType.equals("triangle"))
    // return 0.5 * a * b;
    // if (shapeType.equals("circle"))
    // return 3.14159 * a * a;
    // return -1;
    // }

    // Code smell: Switch Statment
    // Vấn đề: mỗi khi muốn thêm mới thì chúng ta cần phải sửa lại function này
    // --> Vi phạm quy tắc đóng mở (Open/ CLose principle)

    // Kỹ thuật Refactor: Thay thế điều kiện bằng đa hình

    // interface Shape {
    //  double getArea();
    // }

    // class Rectangle implements Shape {
    //  private double width, height;
    //  public Rectangle(double w, double h) { this.width = w; this.height = h; }
    //  public double getArea() { return width * height; }
    // }

    // class Triangle implements Shape {
    //  private double base, height;
    //  public Triangle(double b, double h) { this.base = b; this.height = h; }
    //  public double getArea() { return 0.5 * base * height; }
    // }

    // class Circle implements Shape {
    //  private double radius;
    //  public Circle(double r) { this.radius = r; }
    //  public double getArea() { return Math.PI * radius * radius; }
    // }

    // Bây giờ nếu muốn thêm mới, chỉ cần implement Shape và override lại function getArea()
    
}
