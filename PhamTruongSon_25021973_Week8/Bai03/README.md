# Bài 3: Refactor theo "Small Steps"

## 1. Vấn đề thiết kế
* **Refused Bequest:** Lớp cha `Vehicle` chứa các thuộc tính (`fuelLevel`, `batteryPercent`) mà không phải lớp con nào cũng dùng.
* **Code Duplication:** Phương thức `getInfo()` bị lặp cấu trúc chuỗi ở tất cả lớp con.

## 2. Giải pháp
* **Intermediate Classes:** Tách thành `GasVehicle` và `ElectricVehicle` để chứa các thuộc tính đặc thù.
* **Template Method Pattern:** Đưa logic nối chuỗi `getInfo()` lên lớp cha, các lớp con chỉ cung cấp tên loại xe qua `getVehicleType()`.