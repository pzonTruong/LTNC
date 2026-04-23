# Bài 3: The Buggy Trap (Grade Classifier)

## 1. Đặc tả JavaDoc
- `[0.0, 5.0)` : "Yếu"
- `[5.0, 6.5)` : "Trung bình"
- `[6.5, 8.0)` : "Khá"
- `[8.0, 10.0]` : "Giỏi"

## 2. Nhật ký kiểm thử & Phát hiện lỗi (Bug Report)
Dựa trên kỹ thuật BVA, các lỗi sau đã được phát hiện trong code gốc:

| Input (GPA) | Expected | Actual (Buggy) | Status | Nguyên nhân |
| :--- | :--- | :--- | :--- | :--- |
| 5.0 | "Trung bình" | "Yếu" | **FAIL** | Dùng `<=` thay vì `<` |
| 6.5 | "Khá" | "Trung bình" | **FAIL** | Dùng `<=` thay vì `<` |
| 8.0 | "Giỏi" | "Khá" | **FAIL** | Sai dấu so sánh tại biên |

## 3. Giải pháp khắc phục
Thay đổi điều kiện logic trong hàm `classifyGrade` để khớp chính xác với khoảng đóng/mở trong JavaDoc. 
Sử dụng `assertThrows` để kiểm tra ngoại lệ khi GPA nằm ngoài đoạn `[0, 10]`.