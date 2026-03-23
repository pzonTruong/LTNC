
public class Main {

    public static void main(String[] args) {
        // 1. Tạo khu vực Sách (Chỉ cho phép thêm đối tượng Book)
        LibrarySection<Book> bookSection = new LibrarySection<>("Khu vực Sách Văn Học");
        bookSection.addItem(new Book("B01", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 150));
        bookSection.addItem(new Book("B02", "Số Đỏ", "Vũ Trọng Phụng", 200));

        // 2. Tạo khu vực DVD (Chỉ cho phép thêm đối tượng DVD)
        LibrarySection<DVD> dvdSection = new LibrarySection<>("Khu vực Phim Tài Liệu");
        dvdSection.addItem(new DVD("D01", "Hành tinh xanh", "David Attenborough", 60));
        dvdSection.addItem(new DVD("D02", "Việt Nam thời đại Hồ Chí Minh", "Nhiều đạo diễn", 120));

        // 3. Hiển thị danh sách
        bookSection.displaySection();
        dvdSection.displaySection();

        // 4. Thử nghiệm tính an toàn của Generics
        // dvdSection.addItem(new Book("B03", "Java Core", "NXB Trẻ", 500)); 
        // Dòng trên sẽ báo lỗi biên dịch ngay lập tức: "Incompatible types"
        // 5. Xóa tài liệu và hiển thị lại
        System.out.println("\n--- Thực hiện xóa tài liệu ---");
        bookSection.removeItem("B01");
        bookSection.displaySection();
    }
}
