public class Main {
    public static void main(String[] args) {
        System.out.println("Running....");

        // 1. Bắt đầu với kênh mặc định (Email)
        Notifier stack = new EmailNotifier();

        // 2. Gắn thêm Facebook vào chồng thông báo
        stack = new FacebookNotifier(stack);

        // 3. Gắn thêm SMS vào chồng thông báo
        stack = new SMSNotifier(stack);

        // Gọi gửi thông báo (Nó sẽ chạy qua toàn bộ chuỗi: Email -> Facebook -> SMS)
        System.out.println("Start sending notification...");
        stack.send("Hello, this is a notification message!");
    }
}