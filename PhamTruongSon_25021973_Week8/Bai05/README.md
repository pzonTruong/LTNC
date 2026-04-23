# Bài 5: The Delivery Calculator

## 1. Phân tích Shotgun Surgery
* Ở thiết kế cũ, khi thêm loại đơn hàng **Bulky**, ta phải sửa đồng thời cả hàm tính phí và hàm lấy nhãn trong lớp `Order`.

## 2. Cấu trúc đa hình
* **Lớp cha `Order`:** Định nghĩa các phương thức trừu tượng `getDeliveryFee()` và `getLabel()`.
* **Lớp con:** Mỗi loại đơn hàng (`Standard`, `Express`, `Fragile`, `Bulky`) tự thực hiện công thức riêng.
* **Kết quả:** Code tuân thủ nguyên tắc Open/Closed (OCP).