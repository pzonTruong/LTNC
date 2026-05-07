# Bài 4: Kiểm thử đa hệ điều hành với Matrix Strategy

## 1. Yêu cầu đề bài
Vấn đề "It works on my machine" thường xảy ra do sự khác biệt giữa các hệ điều hành (Windows, Linux, macOS), đặc biệt là trong việc xử lý đường dẫn tệp tin (path separator).

Yêu cầu cụ thể:
- **Matrix Strategy**: Cấu hình GitHub Actions để chạy test đồng thời trên `ubuntu-latest`, `windows-latest`, và `macos-latest`.
- **Unit Test gây lỗi**: Tạo test case sử dụng đường dẫn cứng (ví dụ: `\`) để thấy lỗi trên Linux/macOS.
- **Refactor**: Sử dụng `File.separator` hoặc `java.nio.file.Path` để đảm bảo code chạy đúng trên mọi nền tảng.

## 2. Kiến thức cốt lõi

### GitHub Actions Matrix Strategy
Matrix Strategy cho phép bạn tự động chạy một "job" với nhiều biến thể cấu hình khác nhau. Trong bài này, chúng ta sử dụng biến `matrix.os` để định nghĩa danh sách các hệ điều hành cần kiểm thử.

```yaml
strategy:
  matrix:
    os: [ubuntu-latest, windows-latest, macos-latest]
runs-on: ${{ matrix.os }}
```

### Vấn đề đường dẫn (Path Separator)
- **Windows**: Sử dụng dấu gạch chéo ngược (`\`) làm dấu phân cách đường dẫn.
- **Linux/macOS**: Sử dụng dấu gạch chéo xuôi (`/`).
- **Hệ quả**: Nếu code Java của bạn viết cứng `return "data\\" + fileName;`, nó sẽ chạy đúng trên Windows nhưng gây lỗi `FileNotFoundException` hoặc sai đường dẫn trên Linux.

### Giải pháp trong Java
1. **`File.separator`**: Là hằng số hệ thống trả về dấu phân cách tương ứng với OS đang chạy.
   - Ví dụ: `"data" + File.separator + "storage"`
2. **`java.nio.file.Path` (Khuyên dùng)**: API hiện đại hơn, giúp quản lý đường dẫn an toàn và linh hoạt.
   - Ví dụ: `Path.of("data", "storage", fileName).toString()`

## 3. Cách chạy và Kiểm chứng
1. Cấu hình workflow nằm tại: `.github/workflows/maven-multi-os.yml`
2. Mã nguồn xử lý đường dẫn: `src/main/java/com/example/FileUtils.java`
3. Kiểm thử: Chạy `mvn test` trên các môi trường khác nhau thông qua GitHub Actions.

---
**Ghi chú**: Việc sử dụng Matrix Strategy giúp phát hiện sớm các lỗi đặc thù của hệ điều hành, đảm bảo phần mềm có tính di động (portability) cao.
