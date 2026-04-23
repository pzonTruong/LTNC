# Bài 4: Parking System Refactoring

## 1. Kỹ thuật áp dụng
* **Move Method:** Chuyển logic tính tiền và điểm thưởng từ `ParkingCustomer` sang `ParkingTicket`.
* **Replace Temp with Query:** Sử dụng Stream API để tính tổng tiền thay vì dùng biến tạm tích lũy trong vòng lặp.
* **Polymorphism:** Loại bỏ `switch-case` dựa trên loại xe bằng cách sử dụng các lớp con `Car`, `Bike`, `Truck`.

## 2. Ưu điểm
* Khi thêm loại xe mới, chỉ cần tạo Class mới kế thừa `Vehicle`, không cần sửa code cũ trong `ParkingCustomer`.