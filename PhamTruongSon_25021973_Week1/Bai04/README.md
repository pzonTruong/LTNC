# Giải thuật Fibonacci (Java)

## Mô tả
Chương trình tính số Fibonacci thứ `n` sử dụng vòng lặp tối ưu để tránh lỗi tràn bộ nhớ đệm (StackOverflow) và xử lý tràn số (Overflow) của kiểu dữ liệu `long`.

## Yêu cầu kỹ thuật
- **Phương thức:** `public long fibonacci(long n)`
- **Đầu vào:** Số nguyên `long n` ($n \le 100$).
- **Đầu ra:** - Số Fibonacci thứ $n$.
  - Trả về `-1` nếu $n < 0$.
  - Trả về `Long.MAX_VALUE` nếu kết quả vượt quá giới hạn của kiểu `long`.

## Giải thuật
Sử dụng vòng lặp tuyến tính $O(n)$ để tính toán, kiểm tra tràn số bằng logic: `f1 > Long.MAX_VALUE - f0`.