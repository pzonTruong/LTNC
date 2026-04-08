
public class Main {

    public static void main(String[] args) {
        // Giả sử người dùng chọn gửi qua Email
        NotificationApp app = new EmailApp();
        app.notifyUser("Chào bạn! Bạn có 1 đơn hàng mới.");

        // Chuyển sang gửi qua SMS
        app = new SmsApp();
        app.notifyUser("Ma OTP cua ban la: 123456");
    }
}
