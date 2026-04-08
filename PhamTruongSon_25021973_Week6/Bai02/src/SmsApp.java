// Lớp con cụ thể để tạo SMS

class SmsApp extends NotificationApp {

    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}
