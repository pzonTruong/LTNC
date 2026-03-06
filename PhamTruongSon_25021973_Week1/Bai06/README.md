# Kiểm tra Số nguyên tố (Prime Number)

## Mô tả
Kiểm tra một số nguyên $n$ có phải là số nguyên tố hay không với hiệu suất cao.

## Yêu cầu kỹ thuật
- **Phương thức:** `boolean isPrime(int n)`
- **Độ phức tạp:** $O(\sqrt{n})$, tối ưu hơn so với kiểm tra tuyến tính $O(n)$.

## Giải thuật
Kiểm tra các số từ 3 đến $\sqrt{n}$ (sử dụng điều kiện `i * i <= n`). 
Loại bỏ các trường hợp số chẵn ngay từ đầu để tăng tốc độ thực thi gấp đôi.