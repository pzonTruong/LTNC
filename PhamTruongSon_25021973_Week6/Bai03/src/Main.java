
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
}
