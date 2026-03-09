Bài 2.6: Immutable Object & Deep Copy

Mục tiêu: 
- Hiểu sâu về Encapsulation (Đóng gói), tham chiếu bộ nhớ và bảo mật dữ liệu.

Mô tả nghiệp vụ: 
- Trong hệ thống ngân hàng, một Transaction sau khi được tạo ra thì tuyệt đối không được phép chỉnh sửa. Một Account sẽ lưu trữ một mảng các giao dịch này.

Yêu cầu thiết kế & Cài đặt:
- Lớp Transaction: gồm transactionId, amount, timestamp (dùng String đơn giản).
Đảm bảo không ai có thể sửa đổi dữ liệu của Transaction sau khi gọi constructor.

Lớp Account: gồm accountId, balance và mảng Transaction[] history.
- Có phương thức addTransaction(Transaction t).
- Có phương thức Transaction[] getHistory().

Trong hàm main:
- Viết code đóng vai một hacker: Lấy mảng lịch sử giao dịch từ hàm getHistory(), sau đó cố tình sửa giá trị amount của một giao dịch trong mảng đó thành 9999999. Hoặc gọi history[0] = null.

Yêu cầu bắt buộc: Hãy thiết kế lớp Account sao cho code của "hacker" dù chạy thành công nhưng dữ liệu gốc bên trong đối tượng Account vẫn không bị thay đổi.
