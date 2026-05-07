# Bài 2: Code Quality - Checkstyle & Logging (BankSystem)

Dự án này tập trung vào việc cải thiện chất lượng mã nguồn thông qua việc áp dụng các quy chuẩn lập trình chuyên nghiệp và tăng cường khả năng quan sát hệ thống (observability).

## Yêu cầu của đề bài

1.  **Tích hợp Maven Checkstyle Plugin**: Sử dụng tiêu chuẩn **Google Java Style** để kiểm tra định dạng và phong cách code.
2.  **Tái cấu trúc (Refactor)**: Sửa đổi toàn bộ các vi phạm về đặt tên gói (`package`), thụt lề (`indentation`), và Javadoc.
3.  **Khả năng quan sát (Observability)**: Sử dụng **SLF4J/Logback** để theo dõi hoạt động của hệ thống thay vì dùng `System.out.println`.
4.  **Giải thích**: Làm rõ lý do lựa chọn các cấp độ log và các điểm dữ liệu cần ghi lại.

## Kiến thức cốt lõi

### 1. Code Quality & Checkstyle
- **Quy chuẩn lập trình (Coding Standards)**: Các bộ quy tắc như Google Java Style giúp mã nguồn đồng nhất, dễ đọc và dễ bảo trì khi làm việc nhóm.
- **Checkstyle**: Là công cụ kiểm tra tĩnh (static analysis), giúp tự động phát hiện các lỗi về phong cách như:
    - Đặt tên sai quy tắc (ví dụ: package có dấu gạch dưới).
    - Thụt lề không thống nhất.
    - Thiếu tài liệu hướng dẫn (Javadoc).
- **Lợi ích**: Giảm thiểu lỗi kỹ thuật (technical debt) và nâng cao tính chuyên nghiệp của dự án.

### 2. Khả năng quan sát (Logging Levels)
Việc sử dụng các cấp độ log khác nhau giúp phân loại thông tin một cách hiệu quả:
- **ERROR**: Ghi lại các lỗi hệ thống nghiêm trọng (ví dụ: lỗi đọc file, lỗi logic không mong muốn).
- **WARN**: Cảnh báo các tình huống bất thường nhưng chưa làm dừng hệ thống (ví dụ: rút tiền thất bại do thiếu số dư hoặc vượt hạn mức).
- **INFO**: Ghi lại các sự kiện quan trọng trong quy trình nghiệp vụ (ví dụ: thêm khách hàng mới, thực hiện giao dịch thành công).
- **DEBUG**: Cung cấp thông tin chi tiết cho lập trình viên khi cần tìm lỗi (ví dụ: dữ liệu thô từ file, quá trình tính toán trung gian).

## Giải thích giải pháp

### 1. Giải quyết vi phạm Checkstyle
- **Đặt tên gói (Package Name)**: Chuyển từ `bank_system` sang `banksystem` để tuân thủ quy tắc không sử dụng dấu gạch dưới trong tên package.
- **Thụt lề (Indentation)**: Chỉnh sửa toàn bộ code từ 4 hoặc 8 spaces sang **2 spaces** theo quy chuẩn của Google.
- **Javadoc**: Bổ sung chú thích cho các lớp và phương thức public để hỗ trợ việc tạo tài liệu tự động.

### 2. Cấu hình Logging
- **Logback Configuration**: Cập nhật file `logback.xml` để nhận diện package mới và định dạng log chuyên nghiệp (bao gồm timestamp, thread, level).
- **Các điểm ghi log quan trọng**:
    - Ghi log `INFO` khi một khách hàng hoặc tài khoản được tạo thành công.
    - Ghi log `WARN` khi các quy định về số dư tối thiểu hoặc hạn mức rút tiền bị vi phạm.
    - Ghi log `ERROR` khi có lỗi định dạng dữ liệu trong quá trình đọc danh sách khách hàng.

## Cách chạy dự án
- Chạy lệnh kiểm tra Checkstyle:
  ```bash
  mvn checkstyle:check
  ```
- Chạy lệnh build dự án:
  ```bash
  mvn clean compile
  ```
