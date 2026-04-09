public class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("Gửi Email với nội dung: " + msg);
    }
}