# Tính tổng các chữ số (Sum of Digits)

## Mô tả
Tính tổng của tất cả các chữ số cấu thành nên một số nguyên $n$.

## Yêu cầu kỹ thuật
- **Phương thức:** `int sumOfDigits(int n)`
- **Xử lý:** Chấp nhận cả số âm (tổng chữ số tính dựa trên giá trị tuyệt đối).

## Giải thuật
Sử dụng vòng lặp `while` kết hợp phép toán `/ 10` và `% 10` để lấy từng chữ số cho đến khi hết số gốc.