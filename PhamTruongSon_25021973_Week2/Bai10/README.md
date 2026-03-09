# Bài 2.10: Overloading and ‘this’
## Yêu cầu:  
- Bạn đang viết phần mềm điều khiển cho bóng đèn thông minh (SmartLight). Bóng đèn này có các cấp độ sáng khác nhau và có thể được thiết lập nhanh qua các chế độ (Preset). Tạo lớp SmartLight.

## Thuộc tính (Fields): 
- id (String): Id của đèn
- name (String): Tên của đèn
- brightness (int): Độ sáng của đèn
- Tất cả thuộc tính khai báo là private.

## Hàm khởi tạo (Constructors): 
- Constructor 1 nhận đủ 3 tham số (id, name và brightness), trong khi Constructor 2 còn lại chỉ sử dụng 2 tham số (id, name) và sử dụng this(...) để gọi Constructor 1 và gán brightness mặc định là $50$.

## Phương thức (Methods):
- void setBrightness(int brightness): Cập nhật độ sáng mới (sử dụng this).
- void setBrightness(String preset): Nạp chồng phương thức trên.
- Nếu preset là "MAX", hãy gọi this.setBrightness(100).
- Nếu preset là "MIN", hãy gọi this.setBrightness(10).
- Nếu preset là "ECO", hãy gọi this.setBrightness(30).
- void connectToHub(CentralHub hub): Gọi phương thức hub.registerDevice(this) để đăng ký thiết bị hiện tại vào bộ điều khiển trung tâm (truyền this làm tham số).  

## Hàm main:
- Khởi tạo một đối tượng hub từ lớp CentralHub.
- Tạo bóng đèn l1 bằng Constructor đầy đủ (ví dụ: "L01", "Đèn phòng khách", 80).
- Tạo bóng đèn l2 bằng Constructor 2 tham số (ví dụ: "L02", "Đèn ngủ").
- Thực hiện lệnh l2.setBrightness("ECO").
- Gọi l1.connectToHub(hub) và l2.connectToHub(hub).
- In ra độ sáng hiện tại của cả 2 đèn để kiểm tra kết quả.
- Tạo lớp CentralHub:Một class với phương thức duy nhất là registerDevice(SmartLight light), in ra thông báo: "[HUB] Đang kết nối với thiết bị: " + light.getName()
