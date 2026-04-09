// Lớp thông báo cụ thể qua SMS

class SmsNotification implements Notification {

    @Override // -> QUyết định kiểu (Ở đây chỉ in thông điệp khác)
    public void send(String msg) {
        System.out.println("Sending SMS: " + msg);
    }
}
