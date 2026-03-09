Bài 2.4: Composition & copy
Yêu cầu:
- Tạo class MyDate (day, month, year).
- Tạo class Employee gồm: name (String) và birthday (kiểu MyDate).
- Viết Copy Constructor cho Employee (Constructor nhận vào một Employee khác để sao chép).

Trong main:
- Tạo emp1 với ngày sinh 1/1/2000.
- Tạo emp2 bằng cách sao chép emp1: Employee emp2 = new Employee(emp1);
- Thay đổi ngày sinh của emp1 thành 2/2/2022.
- In ngày sinh của emp2.

Yêu cầu quan trọng: 
- Đảm bảo khi sửa emp1, emp2 KHÔNG bị thay đổi theo. (Thực hiện Deep Copy thay vì Shallow Copy).