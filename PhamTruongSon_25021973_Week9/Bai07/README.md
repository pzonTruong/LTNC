# Bài 7: Automated Code Review via Pull Request

## 1. Yêu cầu đề bài
Biến CI pipeline của bạn thành một "người review" tự động để cung cấp phản hồi ngay lập tức trong quá trình phát triển.

Yêu cầu cụ thể:
- **Trigger**: Cập nhật workflow để trigger khi có sự kiện `pull_request` hướng vào nhánh `main`.
- **Inline Feedback**: Tích hợp action Checkstyle để tự động đăng comment vào các dòng code vi phạm chuẩn.
- **Branch Protection**: Cấu hình Branch Protection Rules để vô hiệu hóa nút Merge khi có lỗi.
- **Verification**: Tạo PR với lỗi Checkstyle cố ý để kiểm chứng.

## 2. Kiến thức cốt lõi

### Automated Code Review là gì?
Thay vì chờ con người review PR, chúng ta cấu hình CI pipeline để tự động phân tích code và đăng nhận xét trực tiếp lên PR. Điều này giúp:
- Phát hiện lỗi sớm, ngay khi mở PR.
- Tiết kiệm thời gian của reviewer con người (chỉ review logic, không review format).
- Đảm bảo code standard nhất quán trong toàn team.

### Checkstyle và Google Style Guide
Checkstyle là một công cụ phân tích tĩnh (static analysis) cho Java, kiểm tra code dựa trên một bộ quy tắc định sẵn. Trong dự án này, chúng ta sử dụng Google Java Style Guide.

**Lỗi cố ý tạo ra** trong `Calculator.java`:
```java
// SAI: Tên hàm viết hoa và dùng dấu gạch dưới
public int Calculate_Sum(int a, int b) { ... }

// ĐÚNG: Tuân theo camelCase
public int calculateSum(int a, int b) { ... }
```

### Cấu hình Workflow kích hoạt bởi Pull Request

```yaml
on:
  push:
    branches: [ main ]
  pull_request:          # ← Thêm trigger này
    branches: [ main ]
```

### GitHub Actions cho Inline Comments
Sử dụng action `dbelyaev/action-checkstyle` để tự động đăng comment trực tiếp vào dòng code vi phạm trong PR:

```yaml
- name: Run Checkstyle
  uses: dbelyaev/action-checkstyle@master
  with:
    github_token: ${{ secrets.GITHUB_TOKEN }}
    reporter: 'github-pr-review'
    checkstyle_config: config/checkstyle.xml
```

### Branch Protection Rules
Cấu hình trên GitHub (Settings → Branches → Branch protection rules):
- **Require status checks to pass before merging**: Kích hoạt status check của workflow CI.
- **Require branches to be up to date before merging**: Đảm bảo nhánh cập nhật trước khi merge.

Kết quả: Nút **Merge** bị vô hiệu hóa (grayed out) nếu CI pipeline thất bại.

## 3. Cách chạy và Kiểm chứng
1. Tạo một nhánh feature mới: `git checkout -b feature/bad-code`
2. Đẩy code có lỗi Checkstyle lên nhánh đó.
3. Mở Pull Request vào `main`.
4. Quan sát: Bot tự động đăng comment vào dòng vi phạm và nút Merge bị khóa.
5. Sửa lỗi, push lại → CI pass → Nút Merge được mở khóa.
