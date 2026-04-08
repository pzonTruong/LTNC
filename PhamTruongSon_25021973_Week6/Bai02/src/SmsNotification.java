// Lớp thông báo cụ thể qua SMS

class SmsNotification implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("Sending SMS: " + msg);
    }
}
