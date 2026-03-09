Bài 2.1: Bank Account 
Mô phỏng một tài khoản ngân hàng đơn giản
Yêu cầu: Tạo lớp BankAccount với các đặc điểm sau:

Thuộc tính (Fields): 
- accountNumber (String): Chỉ đọc, không thay đổi sau khi tạo.
- balance (double): Số dư, không được phép truy cập trực tiếp từ bên ngoài.
- ownerName (String): Tên chủ tài khoản.

Hàm khởi tạo (Constructors):
- Constructor nhận vào accountNumber và ownerName. Số dư mặc định là 0.
- Constructor nhận đủ 3 tham số. Nếu số dư truyền vào < 0, gán mặc định bằng 0 và in thông báo lỗi.

Phương thức (Methods):
- deposit(double amount): Nạp tiền. Số tiền nạp phải > 0.
- withdraw(double amount): Rút tiền. Số tiền rút phải > 0 và <= số dư hiện tại. Trả về true nếu rút thành công, false nếu thất bại.
- getBalance(): Chỉ cho phép xem số dư, không cho phép sửa.

Hàm Main:
- Viết hàm Main theo các kịch bản: nạp tiền âm, rút quá số dư, rút tiền hợp lệ để chứng minh logic bảo vệ dữ liệu hoạt động đúng.
