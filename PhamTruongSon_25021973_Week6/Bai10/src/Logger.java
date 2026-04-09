public class Logger {
    // 1. Thuộc tính static lưu giữ instance duy nhất của lớp
    private static Logger instance;

    // 2. Constructor private để ngăn chặn việc khởi tạo bằng từ khóa 'new' từ bên ngoài
    private Logger() {
        // Có thể khởi tạo file log hoặc cấu hình tại đây
    }

    // 3. Phương thức public static để cung cấp điểm truy cập duy nhất
    public static Logger getInstance() {
        // Kiểm tra nếu instance chưa tồn tại thì mới tạo mới (Lazy Initialization)
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Phương thức ghi log thông tin
    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    // Phương thức ghi log lỗi
    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}