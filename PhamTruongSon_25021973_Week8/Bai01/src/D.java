public class D {
    // class Report {
    // private String title;
    // private String content;
    // private String authorEmail;
    // private String authorName;
    // private String authorPhone;
    // private String authorAddress;
    // }

    // Code Smell: Data Clumps
    // Vấn đề: Các thông tin tác giả và cuốn sách lồng vào nhau, khó để mở rộng
    // Kỹ thuật cần dùng: Extract Class. Gom các thông tin liên quan với nhau thành
    // 1 class

    // Sau refactor:
    // class Author {
    //     private String name;
    //     private String email;
    //     private String phone;
    //     private String address;
    // }

    // class Report {
    //     private String title;
    //     private String content;
    //     private Author author; // Sử dụng đối tượng Author thay vì các trường rời rạc
    // }
}
