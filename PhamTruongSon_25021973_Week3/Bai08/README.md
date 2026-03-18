# Mo ta loi giai

## Tom tat y tuong chinh cua loi giai
(Dien y tuong cua ban tai day)

```
Lấy một đối tượng Robot (nhưng thực chất là DroneRobot) ra khỏi danh sách.
Thử gọi hàm fly(). Có gọi được không?
```
Ans: Không được. Do đối tượng ở đây vẫn là kiểu Robot. Trình biên soạn sẽ không tìm được hàm fly() có sẵn trong lớp Robot.

```
Giả sử bạn có thêm một lớp trừu tượng nữa là ElectronicDevice (Thiết bị điện tử) có phương thức turnOn().
Thử cho DroneRobot kế thừa cả Robot và ElectronicDevice. Kết quả là gì? (Gợi ý: Java có cho phép extends 2 lớp không?).
```
Ans: Java không cho hỗ trợ **Đa kế thừa** với class. Một đối tượng chỉ có 1 abstract class. Để làm gì?: để tránh cả 2 lớp cha đều có chung 1 phương thức nhưng logic khác nhau.

```
Thay vì để ElectronicDevice là lớp trừu tượng, hãy chuyển nó thành Interface. Bây giờ hãy cho DroneRobot vừa extends Robot vừa implements Flyable, GPS, ElectronicDevice. Kết quả thế nào?
```
Ans: Được vì Java cho một class có nhiều Interface cùng một lúc. "Java xử lý đa kế thừa bằng cách này."

## Ly do lua chon huong tiep can nay? Uu diem so voi cac cach khac
(Dien ly do cua ban tai day)

## Cach chay
Chay lenh: ./run.sh
