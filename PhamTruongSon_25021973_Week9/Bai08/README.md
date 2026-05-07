# Bài 8: Đóng gói sản phẩm thực thi (Executable JAR)

## 1. Yêu cầu đề bài
Trong môi trường chuyên nghiệp, phần mềm phải được đóng gói để có thể chạy độc lập mà không cần đến IDE.

Yêu cầu cụ thể:
- **Cấu hình `maven-jar-plugin`**: Chỉ định `Main-Class` trong manifest để tạo executable JAR.
- **Build**: Thực thi lệnh `mvn clean package` để tạo file `.jar` trong thư mục `target`.
- **Xác minh**: Chứng minh ứng dụng khởi chạy được qua terminal bằng lệnh `java -jar target/*.jar`.
- **Giải thích**: Ý nghĩa của thư mục `target` và pha `package` trong Maven.

## 2. Kiến thức cốt lõi

### Vòng đời Build trong Maven (Maven Build Lifecycle)
Maven có 3 vòng đời chính: `default`, `clean`, `site`. Trong vòng đời `default`, các pha quan trọng theo thứ tự là:

```
validate → compile → test → package → verify → install → deploy
```

| Pha | Mô tả |
|-----|-------|
| `compile` | Biên dịch source code `.java` thành bytecode `.class` |
| `test` | Chạy các unit test |
| `package` | Đóng gói thành `.jar` hoặc `.war` vào thư mục `target/` |
| `install` | Cài đặt vào local Maven repository (`~/.m2`) |

### Thư mục `target/`
Thư mục `target/` là nơi Maven lưu toàn bộ kết quả của quá trình build:
- `target/classes/` — Bytecode đã biên dịch
- `target/*.jar` — File JAR được đóng gói
- `target/surefire-reports/` — Báo cáo kết quả test

> **Lưu ý**: Thư mục `target/` **không nên được commit** lên Git (nên có trong `.gitignore`).

### Cấu hình `maven-jar-plugin`
Để tạo Executable JAR (chạy được bằng lệnh `java -jar`), cần chỉ định lớp `Main-Class` trong MANIFEST.MF:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
        <archive>
            <manifest>
                <mainClass>com.example.auction.AuctionServer</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

Kết quả: File JAR được tạo ra sẽ chứa dòng `Main-Class: com.example.auction.AuctionServer` trong `META-INF/MANIFEST.MF`.

### Sự khác biệt: JAR thường vs Executable JAR
- **JAR thường**: `java -cp app.jar com.example.Main` — phải chỉ định class name.
- **Executable JAR**: `java -jar app.jar` — JVM tự đọc `MANIFEST.MF` để tìm điểm khởi chạy.

## 3. Cách chạy và Kiểm chứng
```bash
# 1. Build project
mvn clean package

# 2. Chạy ứng dụng từ JAR
java -jar target/auction-server-app-1.0-SNAPSHOT.jar
```

Kết quả kỳ vọng:
```
=== Booting Online Auction Server ===
[INFO] Initializing SQLite database connection...
[INFO] Configuring socket listeners for real-time bidding...
[INFO] Server is successfully running on port 8080.
```
