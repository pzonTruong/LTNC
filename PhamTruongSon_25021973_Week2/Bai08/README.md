Bài 2.8: Object Reference và Garbage Collection

Yêu cầu: Tạo lớp Person với các đặc điểm sau:

# Thuộc tính (Fields): 
- name(String): Tên của đối tượng.
- me(Person): Tham chiếu đến một đối tượng Person khác.
Tất cả thuộc tính khai báo là private.

# Hàm khởi tạo (Constructors): 
- Constructor nhận vào tham số name và gán cho thuộc tính tương ứng.

# Phương thức (Methods):
- void setMe(Person other): Gán đối tượng other cho tham chiếu me.
- Person getMe(): Trả về đối tượng mà me đang tham chiếu.
- String getName(): Trả về name

# Hàm main:
- Khởi tạo một đối tượng Person và gán cho biến p.
- Set tham chiếu me đến đối tượng mà biến p đang tham chiếu.
- Truy cập và in kết quả của phương thức getName() thông qua biến tham chiếu me của đối tượng p.
- Set biến p = null.

# Yêu cầu:
- Sau khi setMe(p) có bao nhiêu đối tượng Person tồn tại trong bộ nhớ?
- Sau dòng lệnh p = null; đối tượng Person có bị xóa ngay lập tức khỏi bộ nhớ không? Giải thích cơ chế hoạt động của Garbage Collection trong trường hợp này.
- Đối tượng Person có thể được truy cập lại không? Giải thích.
- Vẽ sơ đồ bộ nhớ (Stack và Heap) tại 2 thời điểm: trước và sau khi p = null.
