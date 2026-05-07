# Bài 9: Triển khai Logging chuyên nghiệp (SLF4J & Logback)

## 1. Yêu cầu đề bài
Thay thế tất cả các thói quen kiểm thử lỗi "nghiệp dư" bằng một khung làm việc logging có cấu trúc.

Yêu cầu cụ thể:
- **Loại bỏ `System.out.println()`**: Thay bằng logging có cấu trúc.
- **Tích hợp SLF4J + Logback**: Sử dụng đúng mức log `INFO` và `ERROR`.
- **Parameterized Logging**: Dùng `{}` thay vì cộng chuỗi (`+`).
- **FileAppender**: Cấu hình `logback.xml` để ghi log vào file vật lý.
- **Xác minh**: Chạy `mvn test` và xác nhận log được định dạng đúng.

## 2. Kiến thức cốt lõi

### Vấn đề với `System.out.println()`
`System.out.println()` là cách debug nghiệp dư vì:
- Không có **timestamp** (không biết sự kiện xảy ra lúc nào).
- Không có **log level** (không phân biệt INFO, WARNING, ERROR).
- Không thể **tắt/bật** trong production mà không cần sửa code.
- Không thể **ghi ra file** một cách có cấu trúc.

### Kiến trúc SLF4J + Logback
- **SLF4J (Simple Logging Facade for Java)**: Là một API/interface trừu tượng cho logging. Code của bạn chỉ gọi SLF4J API.
- **Logback**: Là một implementation cụ thể của SLF4J API. Logback xử lý việc định dạng và ghi log ra đâu (console, file, ...).
- **Lợi ích**: Bạn có thể đổi từ Logback sang Log4j2 mà không cần sửa bất kỳ dòng code Java nào.

```
Code Java → gọi SLF4J API → Logback thực thi → Console / File
```

### Các mức độ Log (Log Levels)
Từ ít nghiêm trọng đến nghiêm trọng nhất:

| Level | Khi nào dùng |
|-------|-------------|
| `TRACE` | Chi tiết nhất, debug nội bộ |
| `DEBUG` | Thông tin debug trong quá trình phát triển |
| `INFO` | Các mốc hoạt động quan trọng (request đến, thanh toán thành công) |
| `WARN` | Cảnh báo, hệ thống vẫn hoạt động nhưng có điều gì đó bất thường |
| `ERROR` | Lỗi nghiêm trọng, thường kèm theo Exception |

### Parameterized Logging
**Tránh** cộng chuỗi vì JVM vẫn tạo String ngay cả khi log level đó bị tắt:
```java
// BAD: Luôn tạo String, lãng phí bộ nhớ
logger.debug("User: " + username + " paid: " + amount);

// GOOD: Chỉ tạo String khi DEBUG level được bật
logger.debug("User: {} paid: {}", username, amount);
```

### Cấu hình `logback.xml`
File `logback.xml` trong `src/main/resources/` điều khiển toàn bộ hành vi của Logback:

```xml
<configuration>
    <!-- Appender 1: Ghi ra Console -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Appender 2: Ghi ra File -->
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>logs/application.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Áp dụng cả hai appender cho root logger -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE" />
    </root>
</configuration>
```

### Pattern giải thích
- `%d{...}` — Timestamp với định dạng
- `[%thread]` — Tên thread đang chạy
- `%-5level` — Log level (căn trái, tối đa 5 ký tự)
- `%logger{36}` — Tên class (tối đa 36 ký tự)
- `%msg%n` — Nội dung message và xuống dòng

## 3. Cách chạy và Kiểm chứng
```bash
# Chạy test, log sẽ xuất hiện trên console
mvn test
```

Kết quả kỳ vọng trên console:
```
2026-05-07 21:00:00 [main] INFO  c.e.a.PaymentProcessor - Bắt đầu xử lý thanh toán: $500.0 cho người dùng [alice]
2026-05-07 21:00:00 [main] INFO  c.e.a.PaymentProcessor - Thanh toán thành công cho người dùng [alice]
```

Đồng thời, file `logs/application.log` sẽ được tạo ra với nội dung tương tự.
