# Tính đóng gói (Encapsulation): 
Lớp NotificationApp không hề biết đến sự tồn tại của EmailNotification hay SmsNotification. Nó chỉ làm việc với interface Notification.

# Factory Method (createNotification): 
Đây là trái tim của mẫu thiết kế này. Lớp cha định nghĩa phương thức, nhưng việc "new" đối tượng cụ thể nào lại nằm ở các lớp con (EmailApp, SmsApp).

# Dễ dàng mở rộng (Open/Closed Principle): 
Nếu sau này muốn thêm kênh gửi thông báo qua kiểu khác, bạn chỉ cần tạo thêm lớp Noti và App khác không cần sửa đổi bất kỳ code cũ nào trong NotificationApp.
