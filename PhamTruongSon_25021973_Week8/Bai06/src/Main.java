


public class Main {
    public static void main(String[] args) {
        Student sv = new Student("SV001", "Nguyễn Văn A");
        Course mh = new Course("CS101", "Lập trình Java", 3);
        Grade diem = new Grade(8.0, 7.5, 9.0);

        TranscriptPrinter printer = new TranscriptPrinter(sv, mh, diem);
        printer.printTranscript();
    }

    // 1. Phân tích các trách nhiệm (Responsibilities)
    // Trong thiết kế cũ, StudentManager giống như một "người vận hành" ôm đồm cả thế giới. Chúng ta có thể thấy 3 nhóm dữ liệu/logic hoàn toàn khác biệt bị trộn lẫn:
    // Nhân diện (Identity): Ai đang học? (studentId, name)
    // Học thuật (Academics): Học môn gì? (courseId, courseName, credits)
    // Đánh giá (Assessment): Kết quả ra sao? (midtermScore, finalScore, assignmentScore + logic tính điểm).
    // => Vấn đề: Nếu  muốn đổi công thức tính điểm 
    // (ví dụ: điểm chuyên cần chiếm 10%),  phải sửa vào một lớp đang chứa cả ID sinh viên. Điều này cực kỳ rủi ro và khó bảo trì.
    
    // 2. Giải pháp: Extract Class (Tách lớp)
    // Chúng ta áp dụng kỹ thuật Extract Class để chia nhỏ StudentManager thành các "chuyên gia" thực thụ.
    // Bước 1: Tách thực thể (Entities)
    // Chúng ta tạo ra lớp Student và Course. 
    // Đây là những đối tượng chứa dữ liệu thuần túy (Data Objects). Chúng bền vững và ít thay đổi.
    
    // Bước 2: Tách logic nghiệp vụ (Business Logic)
    // Tạo lớp Grade. Đây là nơi chứa "trái tim" của các phép tính. Lớp này không cần biết sinh viên đó tên gì hay môn đó mã bao nhiêu, nó chỉ quan tâm: "Với 3 đầu điểm này, kết quả tổng kết và xếp loại là gì?".
    
    // Bước 3: Kết nối (Composition)
    // Lớp TranscriptPrinter (Bảng điểm) sẽ đóng vai trò là nơi kết nối (Compose) 3 đối tượng trên lại với nhau để in ra kết quả cuối cùng.
    
    // 3. Tại sao cấu trúc mới lại tốt hơn?
    // Tính tái sử dụng (Reusability): *  có thể dùng đối tượng Course để gán cho một Teacher.
    
    //  có thể dùng đối tượng Student để đăng ký vào một Club.
    
    // Trong thiết kế cũ,  không thể làm điều này vì thông tin môn học và điểm số đã bị "dính chặt" (tightly coupled) vào sinh viên.
    
    // Khả năng mở rộng (Extensibility):

    // Khi yêu cầu thêm TeachingAssistant (Trợ giảng), chúng ta nhận thấy Trợ giảng và Sinh viên đều là Người (Person). Nhờ việc đã tách lớp Student ra trước đó, ta dễ dàng tạo một lớp cha Person để chia sẻ thuộc tính id và name.
    // Dễ dàng kiểm thử (Unit Testing):
    // Bây giờ  có thể viết một bản test cực nhanh cho lớp Grade để đảm bảo công thức tính điểm chính xác mà không cần phải khởi tạo cả một "hệ thống" sinh viên hay môn học cồng kềnh.
}