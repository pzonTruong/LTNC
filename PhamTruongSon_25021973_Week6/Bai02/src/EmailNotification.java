// Lớp thông báo cụ thể qua Email

class EmailNotification implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("Sending Email: " + msg);
    }
}
