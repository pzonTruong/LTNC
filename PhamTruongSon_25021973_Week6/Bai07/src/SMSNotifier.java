public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        // Gọi lại send của các lớp trước đó trong chuỗi
        super.send(msg);
        // Sau đó thực hiện gửi thêm tin nhắn SMS
        System.out.println("SMS notification: " + msg);
    }
}