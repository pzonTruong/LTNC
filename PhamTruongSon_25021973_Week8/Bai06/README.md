# Bài 6: The God Class

## 1. Trách nhiệm của StudentManager (Cũ)
* Lưu thông tin cá nhân.
* Lưu thông tin môn học.
* Tính toán điểm số.
* In bảng điểm.

## 2. Thiết kế mới (Extract Class)
* `Student`: Chỉ quản lý ID và Tên.
* `Course`: Quản lý thông tin môn học và tín chỉ.
* `Grade`: Quản lý điểm thành phần và logic xếp loại.
* `TranscriptPrinter`: Kết hợp các đối tượng trên để hiển thị.

## 3. Mở rộng
* Sử dụng lớp cha `Person` để hỗ trợ thêm các đối tượng khác như `TeachingAssistant`.