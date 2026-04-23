# Bài 1: The Discount Inspector

## 1. Mô tả bài toán
Hàm `calculateDiscount(double price, String memberType)` tính toán mức chiết khấu dựa trên loại thành viên và giá trị đơn hàng.

## 2. Thiết kế Test Case

### A. Phân vùng tương đương (EP) cho `price`
- **Lớp 1:** `price < 0` (Không hợp lệ)
- **Lớp 2:** `0 <= price < 100` (Hợp lệ - Mức thấp)
- **Lớp 3:** `price >= 100` (Hợp lệ - Mức cao)

### B. Bảng Test Case theo EP
| Mã TC | Mô tả | price | memberType | Kết quả mong đợi |
| :--- | :--- | :---: | :---: | :--- |
| TC01 | Price âm | -1.0 | MEMBER | IllegalArgumentException |
| TC02 | Loại member lạ | 100.0 | GOLD | IllegalArgumentException |
| TC03 | GUEST | 50.0 | GUEST | 0.0 |
| TC04 | MEMBER thấp | 50.0 | MEMBER | 2.5 (5%) |
| TC05 | VIP cao | 120.0 | VIP | 24.0 (20%) |

### C. Phân tích giá trị biên (BVA) cho `price`
- **Biên 0:** `-0.01` (Exception), `0.0` (0%), `0.01` (Tính toán bình thường).
- **Biên 100:** `99.99` (Áp dụng mức 5% hoặc 15%), `100.0` (Áp dụng mức 10% hoặc 20%).

### D. 2-way Combinatorial Testing
Đảm bảo mọi cặp (Price Range, MemberType) đều xuất hiện:
- (Âm, GUEST), (Dưới 100, MEMBER), (Trên 100, VIP), (Dưới 100, GUEST), (Trên 100, MEMBER), (Âm, VIP).