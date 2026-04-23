# Bài 2: Extract and Explain

## 1. Các vấn đề đã xử lý
* **Magic Numbers:** Thay thế các con số "lạ" (0.08, 0.015, 11tr) bằng hằng số (Constants) trong `PayrollConstants`.
* **Long Method:** Chia nhỏ phương thức `printPayroll` thành các hàm chuyên biệt: `calculateActualSalary`, `calculateInsurance`, `calculateTax`.
* **Explanatory Variables:** Sử dụng biến trung gian để giải thích các công thức bảo hiểm và thuế.

## 2. Cấu trúc
* `PayrollConstants`: Lưu cấu hình thuế/bảo hiểm.
* `PayrollCalculator`: Chứa logic tính toán thuần túy.
* `Main`: Điều khiển luồng và in kết quả.