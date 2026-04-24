public class Main {
    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("son");

        customer.addTicket(new ParkingTicket(new Car("30A-123.45"), 4)); // 10 + 2*3 = 16
        customer.addTicket(new ParkingTicket(new Bike("29B-999.99"), 5)); // 5 + 2*2 = 9
        customer.addTicket(new ParkingTicket(new Truck("15C-555.55"), 6)); // 15 + 6*4 = 39, bonus 2

        System.out.println(customer.receipt());
    }

    // A. Phương thức receipt() quá tham lam (Long Method & God Method)
    // Phương thức này làm quá nhiều việc:

    // Lặp qua danh sách vé.

    // Chứa công thức tính phí cho từng loại xe.

    // Chứa công thức tính điểm thưởng.

    // Định dạng chuỗi văn bản để in hóa đơn.
    // => Hệ quả: Mỗi khi bãi xe thay đổi giá vé hoặc thêm loại xe mới (ví dụ: Xe
    // điện), bạn phải nhảy vào giữa hàm này để sửa. Rất dễ làm hỏng logic in ấn
    // hoặc tính toán hiện có.

    // B. Feature Envy (Tham lam tính năng)
    // Hàm receipt() nằm trong lớp ParkingCustomer, nhưng nó lại "quan tâm" quá mức
    // đến chi tiết của Vehicle (loại xe là gì để tính tiền). Theo nguyên tắc
    // Information Expert, logic tính tiền nên nằm ở nơi chứa dữ liệu về giá và loại
    // xe.

    // C. Switch Statements (Lạm dụng điều kiện)
    // Sử dụng switch dựa trên type của xe là một dấu hiệu cho thấy bạn đang bỏ qua
    // sức mạnh của Đa hình (Polymorphism). Mỗi lần thêm loại xe mới, danh sách case
    // sẽ dài ra vô tận.

    // 2. Các bước Refactor chi tiết (Small Steps)
    // Bước 1: Extract & Move Method (Tính phí)
    // Đầu tiên, ta tách khối switch tính phí ra khỏi receipt() và chuyển nó về lớp
    // ParkingTicket.

    // Lý do: ParkingTicket biết nó dành cho xe nào và gửi trong bao lâu. Nó là nơi
    // hợp lý nhất để hỏi: "Cái vé này trị giá bao nhiêu tiền?".

    // Bước 2: Extract & Move Method (Điểm thưởng)
    // Tương tự, logic bonusPoints được chuyển vào ParkingTicket.

    // Kết quả: Hàm receipt() bây giờ chỉ cần gọi each.getAmount() và
    // each.getBonusPoints(). Nó không còn cần biết công thức tính tiền phức tạp như
    // thế nào nữa.

    // Bước 3: Replace Conditional with Polymorphism (Loại bỏ Switch)
    // Đây là bước "lột xác" cho hệ thống. Chúng ta xóa bỏ biến int type và thay
    // bằng các lớp con: Car, Bike, Truck.

    // Tại sao? Thay vì dùng switch(type), ta dùng vehicle.getCharge(hours). Java sẽ
    // tự động biết gọi hàm getCharge của lớp Car hay Truck nhờ vào cơ chế đa hình.
}