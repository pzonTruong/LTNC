package com.example.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentProcessor {
    // Khởi tạo Logger cho lớp này
    private static final Logger logger = LoggerFactory.getLogger(PaymentProcessor.class);

    public boolean processPayment(String username, double amount) {
        // Sử dụng Parameterized Logging (dấu {}) thay vì cộng chuỗi ("... " + amount + "...")
        // Điều này giúp tiết kiệm bộ nhớ: SLF4J chỉ thực hiện ghép chuỗi nếu mức độ INFO được bật.
        logger.info("Bắt đầu xử lý thanh toán: ${} cho người dùng [{}]", amount, username);

        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền thanh toán phải lớn hơn 0");
            }
            
            // Giả lập logic xử lý thanh toán thành công
            logger.info("Thanh toán thành công cho người dùng [{}]", username);
            return true;

        } catch (Exception e) {
            // Log mức ERROR kèm theo Exception (e) để in ra toàn bộ Stack Trace
            logger.error("Lỗi khi xử lý thanh toán cho người dùng [{}]: {}", username, e.getMessage(), e);
            return false;
        }
    }
}