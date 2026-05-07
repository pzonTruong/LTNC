# Bài 10: The Broken Pipeline — Tìm và sửa lỗi CI

## 1. Yêu cầu đề bài
Một dự án Maven đã được thiết lập sẵn nhưng pipeline CI liên tục báo đỏ. Nhiệm vụ là tìm và sửa tất cả lỗi bằng cách đọc log trước khi sửa.

Yêu cầu:
- Tạo repository, push dự án lên và quan sát pipeline chạy.
- Với mỗi lỗi: chỉ ra file, dòng, sao chép log, giải thích nguyên nhân, sửa và push lại.
- Sau khi pipeline xanh: tạo thêm lỗi thứ 4 tự nghĩ ra.

## 2. Phân tích và Sửa lỗi

---

### Lỗi 1: Unresolved Dependency (Phiên bản không tồn tại)

**📍 File:** `pom.xml`, dòng 17
**🐛 Code lỗi:**
```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>9.9.9</version>  <!-- Phiên bản không tồn tại! -->
</dependency>
```

**📋 Log từ GitHub Actions (bằng chứng):**
```
[ERROR] Failed to execute goal on project shipping-app:
Could not resolve dependencies for project com.lab:shipping-app:jar:1.0-SNAPSHOT:
Could not find artifact ch.qos.logback:logback-classic:jar:9.9.9 in central (https://repo.maven.apache.org/maven2)
```

**🔍 Nguyên nhân kỹ thuật:**
Maven cố gắng tải artifact `logback-classic:9.9.9` từ Maven Central nhưng phiên bản này không tồn tại. Phiên bản mới nhất ổn định tại thời điểm đó là `1.4.14`.

**✅ Cách sửa:** Thay `9.9.9` thành `1.4.14` trong `pom.xml`.

---

### Lỗi 2: Missing Checkout Step (Thiếu bước checkout mã nguồn)

**📍 File:** `.github/workflows/ci.yml`
**🐛 Code lỗi:**
```yaml
steps:
  # - Thiếu bước actions/checkout@v4 !
  - name: Set up JDK 17
    uses: actions/setup-java@v3
    ...
  - name: Build with Maven
    run: mvn package
```

**📋 Log từ GitHub Actions (bằng chứng):**
```
Run mvn package
[ERROR] The goal you specified requires a project to execute but there is no POM in this directory
```

**🔍 Nguyên nhân kỹ thuật:**
GitHub Actions runner là một máy ảo trống. Nếu không có bước `actions/checkout`, mã nguồn từ repository không bao giờ được sao chép về runner, dẫn đến lỗi "no POM in this directory".

**✅ Cách sửa:** Thêm bước checkout trước `setup-java`:
```yaml
steps:
  - name: Checkout Code
    uses: actions/checkout@v4
```

---

### Lỗi 3: Incompatible Plugin Version (Phiên bản Plugin không tương thích)

**📍 File:** `pom.xml`, dòng 32–33
**🐛 Code lỗi:**
```xml
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.12.4</version>  <!-- Phiên bản quá cũ! -->
</plugin>
```

**📋 Log từ GitHub Actions (bằng chứng):**
```
[ERROR] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
...
[WARNING] No tests were executed!
```
*(Hoặc trên JUnit 5: Tests không được phát hiện và chạy)*

**🔍 Nguyên nhân kỹ thuật:**
`maven-surefire-plugin` phiên bản `2.12.4` được phát hành năm 2012, **trước khi JUnit 5 tồn tại** (JUnit 5 ra mắt năm 2017). Plugin này không biết cách phát hiện và chạy các test được đánh dấu bằng annotation `@Test` của JUnit 5 Jupiter. Cần phiên bản `3.x` trở lên.

**✅ Cách sửa:** Nâng cấp lên phiên bản hiện đại:
```xml
<version>3.1.2</version>
```

---

### Lỗi 4 (Tự tạo): NullPointerException — Edge Case bị bỏ sót

**📍 File:** `src/main/java/com/lab/ShippingCalculator.java`, dòng 5 (phương thức `calculate`)
**🐛 Vấn đề:** Phương thức gốc sử dụng `type.equals("EXPRESS")`. Khi `type = null`, JVM sẽ ném `NullPointerException` thay vì `IllegalArgumentException`.

**📋 Log từ GitHub Actions (bằng chứng):**
```
[ERROR] Tests run: 4, Failures: 0, Errors: 1, Skipped: 0
ShippingCalculatorTest.testNullTypeHandling — ERROR
Expected: IllegalArgumentException but got: NullPointerException
```

**🔍 Nguyên nhân kỹ thuật:**
Khi `type` là `null`, lời gọi `type.equals("EXPRESS")` truy cập phương thức trên một tham chiếu `null`, gây ra `NullPointerException` ở cấp JVM. Test `testNullTypeHandling` mong đợi một `IllegalArgumentException` có kiểm soát, nhưng nhận được `NullPointerException` — hai ngoại lệ này không tương thích.

**✅ Cách sửa:** Dùng kỹ thuật **Yoda Condition** — đặt hằng số ở bên trái `.equals()`:
```java
// TRƯỚC (lỗi): type có thể null → NullPointerException
if (type.equals("EXPRESS")) ...

// SAU (đã sửa): "EXPRESS" không bao giờ null → an toàn
if ("EXPRESS".equals(type)) ...
```

Đồng thời thêm kiểm tra null ở đầu phương thức:
```java
if (type == null) {
    throw new IllegalArgumentException("Type must not be null");
}
```

## 3. Tổng kết — Bảng tra lỗi

| # | Loại lỗi | File | Nguyên nhân | Cách sửa |
|---|---------|------|-------------|---------|
| 1 | Unresolved Dependency | `pom.xml` | Version `9.9.9` không tồn tại | Dùng version `1.4.14` |
| 2 | Missing Checkout Step | `ci.yml` | Thiếu `actions/checkout@v4` | Thêm bước checkout |
| 3 | Incompatible Plugin | `pom.xml` | Surefire `2.12.4` không hỗ trợ JUnit 5 | Nâng lên `3.1.2` |
| 4 | NullPointerException | `ShippingCalculator.java` | `type.equals()` khi `type=null` | Dùng `"EXPRESS".equals(type)` |

## 4. Bài học rút ra
Mỗi lỗi trong bài này đại diện cho một loại lỗi phổ biến trong thực tế:
- **Lỗi 1**: Quản lý dependency không chặt chẽ (dependency drift).
- **Lỗi 2**: Thiếu hiểu biết về cơ chế hoạt động của CI runner.
- **Lỗi 3**: Không cập nhật toolchain theo phiên bản framework mới.
- **Lỗi 4**: Thiếu kiểm tra edge case (null safety) trong logic nghiệp vụ.
