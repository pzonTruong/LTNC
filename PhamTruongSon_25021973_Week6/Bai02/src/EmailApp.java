// Lớp con cụ thể để tạo Email

class EmailApp extends NotificationApp {

    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
