public class Main {
    public static void main(String[] args) {
        // Lấy đối tượng Logger lần thứ nhất
        Logger logger1 = Logger.getInstance();
        
        // Lấy đối tượng Logger lần thứ hai ở một nơi khác trong code
        Logger logger2 = Logger.getInstance();

        // Kiểm tra xem hai biến có cùng trỏ về một vùng nhớ (địa chỉ) không
        boolean isEqual = (logger1 == logger2);
        System.out.println("Logger instances equal: " + isEqual);

        // Ghi các log khác nhau
        logger1.logInfo("Application started");
        logger2.logInfo("Processing data...");
        logger1.logError("Something went wrong");
    }
}