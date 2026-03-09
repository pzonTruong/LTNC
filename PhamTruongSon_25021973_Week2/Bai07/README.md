Bài 2.7: Pass-by-Reference & Deep Copy

Mục tiêu: 
- Phân biệt "Shallow Copy" (Sao chép nông) và "Deep Copy" (Sao chép sâu). 

Mô tả nghiệp vụ: 
- Hệ thống bán hàng có lớp Product và lớp Inventory (Kho hàng). Kho hàng quản lý một mảng các sản phẩm.

Yêu cầu thiết kế & Cài đặt:
- Tạo lớp Product: gồm id, name, price.
- Tạo lớp Inventory:
- Thuộc tính Product[] items.

Hàm khởi tạo: 
- public Inventory(Product[] initialItems) gán mảng đưa vào thành mảng của kho.

Trong hàm main:
- Tạo một mảng Product[] arr gồm 2 sản phẩm (Vd: Laptop giá 1000$).
- Khởi tạo kho: Inventory kho = new Inventory(arr).
- Bên ngoài hàm main, gọi arr[0].setPrice(5000$).

Sau đó, in danh sách sản phẩm trong đối tượng kho ra màn hình.