# Bài 3: CI/CD Automation với GitHub Actions (MathUtils)

Dự án này minh họa việc thiết lập một quy trình tích hợp liên tục (Continuous Integration) tự động hóa các bước kiểm thử và đóng gói ứng dụng bằng GitHub Actions.

## Yêu cầu của đề bài

1.  **Thiết lập Workflow**: Tạo quy trình GitHub Actions tự động kích hoạt khi có sự kiện `push` hoặc `pull_request` vào nhánh `main`.
2.  **Thực thi Maven Lifecycle**: Tự động chạy các pha `test` và `package` của Maven.
3.  **Lưu trữ Artifact**: Sử dụng action `upload-artifact` để lưu trữ tệp `.jar` được tạo ra sau khi build.
4.  **Kiểm thử và Debug**: Cố tình gây lỗi build (thông qua Unit Test sai) để minh chứng khả năng giám sát và xử lý lỗi thông qua execution logs.

## Kiến thức cốt lõi

### 1. CI/CD (Continuous Integration / Continuous Deployment)
- **Continuous Integration (CI)**: Là quy trình tự động hóa việc tích hợp code của nhiều thành viên trong nhóm lại với nhau. CI giúp phát hiện lỗi sớm ngay khi code được đẩy lên kho lưu trữ.
- **Lợi ích**: Giảm thiểu rủi ro khi tích hợp, đảm bảo mã nguồn luôn ở trạng thái có thể build thành công.

### 2. GitHub Actions
- **Workflow**: Được định nghĩa trong file `.yml` đặt tại thư mục `.github/workflows/`. Nó quy định các quy tắc và bước thực hiện tự động.
- **Runners**: Các máy ảo (ví dụ: `ubuntu-latest`) do GitHub cung cấp để thực thi các lệnh trong workflow.
- **Actions**: Các đơn vị công việc có sẵn (ví dụ: `actions/checkout` để lấy code, `actions/setup-java` để cài đặt môi trường Java).

### 3. Artifacts trong CI/CD
- **Artifact**: Là kết quả đầu ra của quá trình build (ví dụ: file `.jar`, tệp thực thi, báo cáo test).
- **Upload Artifact**: Việc lưu giữ lại các tệp này sau khi build giúp người dùng có thể tải về và kiểm tra sản phẩm cuối cùng mà không cần build lại trên máy cá nhân.

## Giải thích giải pháp

### 1. Cấu trúc Workflow (`maven-ci.yml`)
- **Triggers**: Workflow được thiết lập để chạy mỗi khi có thay đổi ở nhánh `main`.
- **Maven Package**: Lệnh `mvn clean package` thực hiện:
    - Biên dịch mã nguồn.
    - Chạy các Unit Tests.
    - Nếu test pass, sẽ đóng gói thành file `.jar`.
- **Upload Step**: Nếu build thành công, file `mathutils-1.0-SNAPSHOT.jar` sẽ được upload lên hệ thống lưu trữ của GitHub với tên `mathutils-executable`.

### 2. Kịch bản lỗi và Debug (Lưu ý quan trọng)
Trong file `MathUtilsTest.java`, tôi đã cố tình để một lỗi logic tại bài test cộng:
```java
assertEquals(99, mathUtils.add(7, 3), "7 + 3 should be 10");
```
- **Kết quả**: Khi workflow chạy, bước "Build with Maven" sẽ thất bại (Fail) vì Unit Test không vượt qua.
- **Cách Debug**: 
    1. Truy cập vào tab **Actions** trên GitHub repository.
    2. Chọn lần chạy gần nhất bị báo đỏ (Failure).
    3. Nhấp vào job **build** và xem log của bước **Build with Maven**.
    4. Log sẽ chỉ rõ: `Expected: 99, Actual: 10`. Từ đó lập trình viên biết chính xác vị trí và nguyên nhân lỗi để sửa.

## Cách thực hiện
1. Đẩy mã nguồn lên GitHub.
2. Kiểm tra tab **Actions** để xem quy trình CI tự động chạy.
3. Để build thành công, hãy sửa giá trị `99` thành `10` trong `MathUtilsTest.java` và push lại code.
