public class AppConfig {
    // 1. volatile giúp đảm bảo các luồng đọc được giá trị mới nhất của instance ngay khi nó được khởi tạo
    private static volatile AppConfig instance;

    // Các thuộc tính cấu hình
    private String appName;
    private String version;
    private String logLevel;

    // 2. Private constructor: Ngăn chặn việc khởi tạo đối tượng từ bên ngoài bằng từ khóa 'new'
    private AppConfig() {
        // Giả lập việc đọc cấu hình từ file hoặc DB
        this.appName = "My Awesome App";
        this.version = "1.0.0";
        this.logLevel = "DEBUG";
    }

    // 3. Phương thức getInstance() theo kiểu Lazy Initialization & Double-Checked Locking
    public static AppConfig getInstance() {
        // Kiểm tra lần 1: Nếu instance đã tồn tại thì return ngay, không cần vào block synchronized (tăng hiệu năng)
        if (instance == null) {
            synchronized (AppConfig.class) {
                // Kiểm tra lần 2: Đảm bảo nếu 2 luồng cùng vào đến đây thì chỉ luồng đầu tiên được tạo object
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // Các getter/setter để truy xuất cấu hình
    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public String getLogLevel() { return logLevel; }
}