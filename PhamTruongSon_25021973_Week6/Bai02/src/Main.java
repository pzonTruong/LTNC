
public class Main {

    public static void main(String[] args) {
        // Giả sử người dùng chọn gửi qua Email
        NotificationApp app = new EmailApp();
        app.notifyUser("Sending OTP code ....");

        // Chuyển sang gửi qua SMS
        app = new SmsApp();
        app.notifyUser("Your OTP code: 67676767");
    }

    // app sẽ gửi các noti kiểu khác nhau mà vẫn đi theo nguyên lí O trong SOLID: 
    // Close for Modification, Open for extension.
}
