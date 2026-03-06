public class Main{
    public static void main() {
        Person p = new Person("Son");
        p.setMe(p);

        System.out.println("Me: " + p.getName());
        p = null;

        // System.out.println("Me: " + p.getName()); -> Error

        /*
        Sau khi setMe(p) có bao nhiêu đối tượng Person tồn tại trong bộ nhớ?
        - Chỉ có 1 đối tượng trong bộ nhớ Heap.

        Sau dòng lệnh p = null; đối tượng Person có bị xóa ngay lập tức khỏi bộ nhớ không? Giải thích cơ chế hoạt động của Garbage Collection trong trường hợp này.
        - Sẽ không bị xóa ngay lặp tức, cơ chế của Garbage collection chỉ xóa khi thiếu bộ nhớ hoặc chạy theo định kì.

        Đối tượng Person có thể được truy cập lại không? Giải thích.
        - Đối tượng sau khi set = null sẽ không truy cập lại được vì không còn tham chiếu nào trỏ vào đối tượng.

        Vẽ sơ đồ bộ nhớ (Stack và Heap) tại 2 thời điểm: trước và sau khi p = null.
        Before
        Stack:
        p: 1
        Heap:
        Địa chỉ 1: {name: "Son", me: 1}

        After
        Stack:
        p = null
        Heap:
        Địa chỉ 1: {name: "Son", me: 1}
         */
    }
}