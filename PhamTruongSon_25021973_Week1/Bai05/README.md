# Tìm Ước số chung lớn nhất (GCD)

## Mô tả
Triển khai tìm ước số chung lớn nhất của hai số nguyên $a$ và $b$ dựa trên giải thuật Euclid cổ điển.

## Yêu cầu kỹ thuật
- **Phương thức:** `int gcd(int a, int b)`
- **Đặc điểm:** - Xử lý được số âm (lấy giá trị tuyệt đối).
  - Xử lý trường hợp một hoặc cả hai số bằng 0.

## Giải thuật
Sử dụng giải thuật Euclid với phép chia lấy dư: $gcd(a, b) = gcd(b, a \pmod{b})$. 
Độ phức tạp thời gian thấp, đạt hiệu quả tối ưu.