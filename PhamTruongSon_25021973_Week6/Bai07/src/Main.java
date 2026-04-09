public class Main {
    public static void main(String[] args) {
        System.out.println("--- Khởi tạo hệ thống thông báo đa kênh ---");

        // 1. Bắt đầu với kênh mặc định (Email)
        Notifier stack = new EmailNotifier();

        // 2. Gắn thêm Facebook vào chồng thông báo
        stack = new FacebookNotifier(stack);

        // 3. Gắn thêm SMS vào chồng thông báo
        stack = new SMSNotifier(stack);

        // Gọi gửi thông báo (Nó sẽ chạy qua toàn bộ chuỗi: Email -> Facebook -> SMS)
        System.out.println("Bắt đầu gửi thông báo:");
        stack.send("Chào mừng bạn đến với hệ thống của chúng tôi!");
    }
}