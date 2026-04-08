// Lớp trừu tượng định nghĩa Factory Method

abstract class NotificationApp {

    // Logic nghiệp vụ: Không quan tâm Notification là loại nào, chỉ gọi send()
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }

    // Factory Method: Để các lớp con quyết định loại đối tượng được tạo ra
    protected abstract Notification createNotification();
}
