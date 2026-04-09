
public class Main {

    public static void main(String[] args) {
        Application app;
        UIFactory factory;

        // Giả lập nhận tham số cấu hình
        String osType = "win"; // Hoặc "mac"

        if (osType.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else if (osType.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            System.out.println("Hệ điều hành không hỗ trợ!");
            return;
        }

        // Khởi tạo ứng dụng với factory tương ứng
        app = new Application(factory);
        app.paint();
    }

    // Áp dụng Abstract Factory Pattern
    // sử dụng Singleton Pattern để đảm bảo chỉ có một instance của mỗi factory
    // sử dụng nguyên lí open/closed để dễ dàng mở rộng thêm các loại giao diện khác trong tương lai
}
