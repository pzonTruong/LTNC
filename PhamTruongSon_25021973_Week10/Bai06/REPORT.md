# Báo cáo Phân tích Hệ thống Giám sát Thời tiết

## 1. Phân tích Ngoại lệ khi chạy đồng thời hai CommandServer
Khi cố gắng khởi chạy hai thực thể `CommandServer` trên cùng một cổng (5000), ngoại lệ **`java.net.BindException: Address already in use`** sẽ xảy ra.

**Lý do:**
- Trong kiến trúc mạng, mỗi cổng (Port) là một điểm cuối duy nhất được gán cho một tiến trình cụ thể.
- Hệ điều hành không cho phép nhiều ứng dụng cùng "chiếm giữ" (bind) một cổng TCP tại một thời điểm để tránh xung đột trong việc định tuyến dữ liệu.
- Việc xử lý `BindException` trong code giúp hệ thống đưa ra cảnh báo thân thiện thay vì bị crash đột ngột.

## 2. Sự khác biệt giữa TCP và UDP khi vắng bóng đối tác
Trong quá trình kiểm thử, chúng ta quan sát thấy sự khác biệt rõ rệt giữa `CommandClient` (TCP) và `SensorSender` (UDP).

### TCP (CommandClient): Báo lỗi ngay lập tức
- **Hiện tượng:** Nếu `CommandServer` chưa chạy, `CommandClient` ném ra ngoại lệ `ConnectException` với thông báo "Error: Remote server is offline!".
- **Bản chất:** TCP là giao thức **hướng kết nối (connection-oriented)**. Nó yêu cầu thiết lập một kết nối tin cậy thông qua quá trình "bắt tay 3 bước" (three-way handshake) trước khi truyền dữ liệu. Khi không tìm thấy Server đang lắng nghe, tiến trình này thất bại ngay lập tức.

### UDP (SensorSender): Không báo lỗi
- **Hiện tượng:** `SensorSender` vẫn gửi dữ liệu bình thường và thông báo "Sent: Temp: 28°C..." dù `SensorReceiver` có đang chạy hay không.
- **Bản chất:** UDP là giao thức **phi kết nối (connectionless)**. Nó hoạt động theo nguyên tắc "gửi và quên" (fire-and-forget). Dữ liệu được đóng gói vào các Datagram và đẩy ra mạng mà không cần kiểm tra trạng thái của bên nhận. Điều này giúp UDP có tốc độ cực nhanh (phù hợp cho viễn trắc thời gian thực) nhưng không đảm bảo dữ liệu đã được nhận.

## 3. Tổng kết
- **TCP** phù hợp cho kênh **Điều khiển** vì yêu cầu tính chính xác và xác nhận trạng thái cao.
- **UDP** phù hợp cho kênh **Viễn trắc** (Telemetry) vì yêu cầu tốc độ và chấp nhận mất mát dữ liệu nhỏ trong môi trường thời gian thực.
