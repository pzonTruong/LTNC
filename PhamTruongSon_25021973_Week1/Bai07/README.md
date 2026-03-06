# Đảo ngược số nguyên (Reverse Integer)

## Mô tả
Đảo ngược thứ tự các chữ số của một số nguyên $n$, bao gồm cả số âm và số có chữ số 0 ở cuối.

## Yêu cầu kỹ thuật
- **Phương thức:** `int reverse(int n)`
- **Xử lý tràn số:** Nếu kết quả sau khi đảo ngược vượt quá phạm vi `int` ($-2^{31}$ đến $2^{31}-1$), phương thức trả về `0`.

## Giải thuật
- Sử dụng vòng lặp tách chữ số hàng đơn vị bằng `% 10` và xây dựng số mới bằng cách nhân với 10. 
- Sử dụng kiểu `long` trung gian để kiểm tra tràn số.