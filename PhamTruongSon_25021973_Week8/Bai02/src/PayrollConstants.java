public class PayrollConstants {
    // Tỷ lệ bảo hiểm
    public static final double SOCIAL_INSURANCE_RATE = 0.08;
    public static final double HEALTH_INSURANCE_RATE = 0.015;

    // Các mốc thuế TNCN
    public static final double PERSONAL_DEDUCTION = 11000000;
    public static final double TAX_LEVEL_1_LIMIT = 5000000;
    public static final double TAX_LEVEL_2_LIMIT = 10000000;

    // Thuế suất và số thuế tính sẵn
    public static final double TAX_RATE_LEVEL_1 = 0.05;
    public static final double TAX_RATE_LEVEL_2 = 0.10;
    public static final double TAX_BASE_LEVEL_2 = 250000; // 5tr * 0.05
    public static final double TAX_BASE_LEVEL_3 = 750000; // 250k + (5tr * 0.1)

    // Thay thế Magic Numbers bằng Constant
    // Thay vì viết actualSalary * 0.08, chúng ta viết actualSalary * SOCIAL_INSURANCE_RATE. 
    // Điều này giúp:

    // Dễ hiểu: Người đọc biết ngay 0.08 là tỷ lệ bảo hiểm xã hội.

    // Dễ sửa đổi: Nếu nhà nước thay đổi tỷ lệ bảo hiểm, thì chỉ cần sửa ở 1
    // nơi duy nhất (biến hằng số).
}