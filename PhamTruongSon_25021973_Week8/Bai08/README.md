# Bài 2: Math Utils Unit Test

## 1. Nội dung kiểm thử
Thực hiện Unit Test cho class `MathUtils` bao gồm hai phương thức:
- `max(int a, int b)`: Tìm số lớn nhất.
- `divide(int a, int b)`: Thực hiện phép chia nguyên.

## 2. Chiến lược kiểm thử
### Phương thức `max(int a, int b)`
- **EP:** Kiểm tra 3 trường hợp: `a > b`, `a < b`, `a = b`.
- **BVA:** Sử dụng các giá trị cực trị của kiểu dữ liệu Integer: `Integer.MAX_VALUE` và `Integer.MIN_VALUE`.

### Phương thức `divide(int a, int b)`
- **EP:** Chia cho số dương, số âm.
- **Ngoại lệ:** Kiểm tra trường hợp chia cho `0`, kỳ vọng ném ra `IllegalArgumentException`.

## 3. Cấu trúc JUnit
Sử dụng `@BeforeAll` và `@AfterAll` để đánh dấu vòng đời chạy test.
*Lưu ý: `@BeforeAll` phải là static vì nó được gọi trước khi instance của class test được khởi tạo.*