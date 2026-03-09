Bài 2.9: Static Methods and Standard IO:

# Yêu cầu: 
Bạn đang xây dựng phần mềm quản lý kho cho chuỗi cửa hàng. Hệ thống cần quản lý các sản phẩm riêng lẻ, nhưng cũng phải theo dõi các thông số chung của toàn hệ thống như mức thuế VAT và tổng doanh thu toàn chuỗi. Tạo lớp Product với các đặc điểm sau:

# Thuộc tính (Fields): 
- Tất cả các thuộc tính được khai báo là private.
- Instance Fields: name (String), price (double), quantity (int) - số lượng hàng tồn kho và discount (double) - Mức giảm giá cho từng sản phẩm. 
- Static Fields: taxRate (double) - Mức thuế VAT chung (mặc định là 0.1) và totalRevenue (double) - Tổng doanh thu từ tất cả các giao dịch bán hàng (khởi tạo bằng 0).
Constructor: Constructor nhận đủ các tham số để gán giá trị cho (name, price, quantity, và discount).

# Phương thức (Methods):
- static void updateTaxRate(double newRate): Cập nhật mức thuế VAT mới cho toàn hệ thống.
- double calculateFinalPrice(): Tính giá cuối cùng của sản phẩm sau khi trừ giảm giá riêng và cộng thuế VAT dùng chung. Công thức: finalPrice = (price - discount) x (1 + taxRate)
- void updateDiscount(double newDiscount): Cập nhật mức giảm giá mới cho sản phẩm.
- void sell(int amount): Nếu amount <= quantity: Trừ số lượng tồn kho, tính tiền thực tế thu được (amount x finalPrice) và cộng dồn vào biến tĩnh totalRevenue. In thông báo thành công ra System.out. Nếu amount > quantity: In thông báo lỗi "Không đủ hàng trong kho" ra System.err.

# Hàm main:
- Sử dụng lớp Scanner: Nhập liệu dữ liệu và khởi tạo 2 đối tượng Product p1 và p2 với thông tin (name, price, quantity, discount) nhập từ bàn phím.
- Thực hiện giao dịch: Yêu cầu người dùng nhập số lượng cần mua cho p1 và p2 và gọi hàm p1.sell() và p2.sell().

# Kiểm tra tính chất Static: 
- In giá cuối cùng (calculateFinalPrice) của cả p1 và p2.
- Gọi hàm tĩnh Product.updateTaxRate(0.08) (giảm thuế xuống 8%). In lại giá cuối cùng của p1 và p2 một lần nữa để quan sát sự thay đổi trong mức giá của cả hai sản phẩm sau khi giảm thuế.
- Gọi hàm p1.updateDiscount(10.0) (Thay mức giảm của sản phẩm bằng 10). In ra giá trị cuối cùng của p1 và p2 một lần nữa để quan sát sự thay đổi khi chỉ giảm giá của một sản phẩm.
- In tổng doanh thu toàn hệ thống (totalRevenue).
