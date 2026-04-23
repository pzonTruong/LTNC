# Bài 1: The Smell Hunter

## 1. Phân tích Code Smell
* **Đoạn A:** *Mysterious Name*. Tên biến (`t`, `h`, `r`, `m`) không mang ý nghĩa nghiệp vụ.
* **Đoạn B:** *Large Class / SRP Violation*. Lớp `UserService` ôm đồm quá nhiều việc (gửi mail, render, export).
* **Đoạn C:** *Switch Statements*. Sử dụng chuỗi `if-else` để phân loại đối tượng, gây khó khăn khi mở rộng (vi phạm OCP).
* **Đoạn D:** *Data Clumps*. Các trường thông tin tác giả luôn đi cùng nhau nhưng lại khai báo rời rạc.

## 2. Giải pháp Refactor
* **Rename Variables/Functions:** Đặt lại tên tường minh.
* **Extract Class:** Tách các trách nhiệm gửi mail, render sang lớp chuyên biệt.
* **Polymorphism:** Sử dụng kế thừa/interface cho các loại hình học.
* **Introduce Parameter Object:** Gom nhóm thông tin tác giả thành lớp `Author`.