# Bài 1: Quản lý Dependency với Maven - Dự án MathUtils

Dự án này minh họa việc nâng cấp cấu hình Maven từ một dự án cũ sang sử dụng các thư viện hiện đại, giải quyết xung đột và áp dụng các kiến thức cốt lõi về quản lý dự án Java.

## Yêu cầu của đề bài

1.  **Thay thế logging thủ công**: Loại bỏ các lệnh `System.out.println` và thay thế bằng **Logback Classic 1.4.11** để ghi log có cấu trúc.
2.  **Tích hợp Hibernate**: Thêm **Hibernate Core 6.2.0.Final** để chuẩn bị cho nhu cầu lưu trữ dữ liệu (ORM).
3.  **Nâng cấp Testing Framework**: Chuyển toàn bộ dự án sang sử dụng **JUnit Jupiter 5.9.2** (JUnit 5) làm công cụ kiểm thử duy nhất.
4.  **Giải quyết xung đột**: Đảm bảo file `pom.xml` hợp lệ, không có xung đột phiên bản và dự án build thành công.

## Kiến thức cốt lõi

### 1. Quản lý Dependency với Maven
- **POM (Project Object Model)**: File `pom.xml` là trái tim của Maven, chứa thông tin cấu hình dự án và danh sách các thư viện phụ thuộc.
- **Dependency Coordination**: Bao gồm `groupId` (tổ chức), `artifactId` (tên dự án), và `version` (phiên bản).
- **Scope**: Quyết định khi nào một thư viện được sử dụng (ví dụ: `test` scope chỉ dành cho việc chạy unit test).
- **Properties**: Sử dụng thẻ `<properties>` để quản lý tập trung các phiên bản thư viện, giúp dễ dàng nâng cấp và tránh sai sót.

### 2. Ghi log có cấu trúc (Structured Logging)
- **SLF4J (Simple Logging Facade for Java)**: Cung cấp một giao diện (interface) chung cho việc ghi log, giúp code không bị phụ thuộc cứng vào một thư viện cụ thể.
- **Logback**: Là bộ khung ghi log (implementation) mạnh mẽ, kế thừa từ Log4j, hỗ trợ cấu hình linh hoạt qua file `logback.xml`.
- **Lợi ích**: 
    - Phân chia mức độ quan trọng: `DEBUG`, `INFO`, `WARN`, `ERROR`.
    - Định dạng log chuyên nghiệp (thời gian, thread, class name).
    - Hiệu năng cao hơn so với `System.out.println`.

### 3. Hibernate Core (ORM)
- **ORM (Object-Relational Mapping)**: Kỹ thuật ánh xạ các đối tượng Java sang các bảng trong cơ sở dữ liệu quan hệ.
- **Hibernate**: Framework ORM phổ biến nhất cho Java, giúp giảm bớt lượng code JDBC thủ công, hỗ trợ quản lý giao dịch và truy vấn linh hoạt.

### 4. JUnit Jupiter (JUnit 5)
- Là thế hệ tiếp theo của JUnit, bao gồm 3 module chính: Jupiter, Platform và Vintage.
- **Cải tiến so với JUnit 4**:
    - Sử dụng các Annotation mới: `@BeforeEach` (thay cho `@Before`), `@AfterEach`, `@DisplayName`.
    - Hỗ trợ Java 8+ features như Lambda expressions trong assertions (`assertThrows`).
    - Khả năng mở rộng (Extension API) tốt hơn.

## Giải thích giải pháp

1.  **Cấu hình `pom.xml`**: 
    - Đã cập nhật phiên bản các thư viện đúng theo yêu cầu (Logback 1.4.11, Hibernate 6.2.0.Final, JUnit 5.9.2).
    - Sử dụng property `${junit.jupiter.version}` để đồng bộ phiên bản `junit-jupiter-api` và `junit-jupiter-engine`.
    - Thêm `maven-surefire-plugin` phiên bản 3.0.0 để hỗ trợ chạy JUnit 5 tests một cách ổn định.
2.  **Mã nguồn `MathUtils.java`**:
    - Khởi tạo `Logger` từ `LoggerFactory`.
    - Sử dụng `logger.info()`, `logger.debug()` và `logger.error()` thay cho `System.out.println`.
3.  **Kiểm thử `MathUtilsTest.java`**:
    - Sử dụng các gói `org.junit.jupiter.api.*`.
    - Áp dụng `@DisplayName` để mô tả bài test rõ ràng hơn.
    - Sử dụng `assertThrows` để kiểm tra ngoại lệ một cách hiện đại.

## Cách chạy dự án
- Yêu cầu: Đã cài đặt JDK 11+ và Maven.
- Chạy lệnh sau để build và chạy tests:
  ```bash
  mvn clean test
  ```
- Hoặc sử dụng script có sẵn:
  ```bash
  ./run.sh
  ```
