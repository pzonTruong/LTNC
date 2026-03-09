Bài 2.2: Student
Yêu cầu: Xây dựng lớp Student mô tả sinh viên với các thuộc tính: id (mã SV), name (tên), email, gpa (điểm trung bình).

Encapsulation: Tất cả các thuộc tính phải là private.
Constructor: Tạo 3 constructor:
- Không tham số.
- Có tham số (id, name).
- Có đầy đủ tham số (Copy constructor).

Validation: 
- Trong các hàm setter (ví dụ: setGpa), phải kiểm tra logic (VD: GPA phải từ 0.0 đến 4.0). Nếu sai, phải in ra lỗi hoặc giữ nguyên giá trị cũ.

Viết hàm main tạo 3 sinh viên bằng 3 cách khác nhau, thử gán GPA < 0 và in thông tin ra màn hình.
