# Tìm số lớn thứ hai trong mảng

## Mô tả
Tìm giá trị lớn thứ hai (khác với giá trị lớn nhất) trong một mảng số nguyên không được sắp xếp.

## Yêu cầu kỹ thuật
- **Phương thức:** `int secondLargest(int[] arr)`
- **Độ phức tạp:** $O(n)$ (Chỉ duyệt mảng 1 lần).

## Giải thuật
Duy trì hai biến `largest` và `secondLargest`. Cập nhật đồng thời khi duyệt qua từng phần tử của mảng, đảm bảo xử lý được cả mảng có các phần tử trùng nhau.