# Bài 4: The Bank Account Tester

## 1. Chức năng
Kiểm thử lớp `BankAccount` với các hành vi: Nạp tiền (`deposit`) và Rút tiền (`withdraw`).

## 2. Thiết kế Test Case
### Đối với `withdraw(amount)`:
- **Hợp lệ:** Rút số tiền nhỏ hơn số dư.
- **Biên:** Rút đúng bằng số dư (Số dư về 0).
- **Thất bại:** Rút lớn hơn số dư (Trả về `false`).
- **Ngoại lệ:** Rút số tiền `<= 0`.

## 3. Kiểm tra tính nhất quán (Sequence Test)
Kịch bản kiểm thử luồng nghiệp vụ liên tục:
1. Tạo TK mới (Balance = 0).
2. Nạp 500 (Balance = 500).
3. Rút 200 thành công (Balance = 300).
4. Rút 400 thất bại (Balance vẫn phải là 300).

## 4. Kỹ thuật JUnit
Sử dụng `@BeforeEach` để khởi tạo lại đối tượng `BankAccount` trước mỗi test case, đảm bảo các bài test không gây tác dụng phụ lẫn nhau.