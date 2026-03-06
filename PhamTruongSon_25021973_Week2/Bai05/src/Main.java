public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "hello", 150000.0);
        Book book2 = new Book("book1", "hello", 150000.0);

        boolean result1 = (book1 == book2);
        System.out.println("So sánh bằng '=='     : " + result1); // Kết quả: false -> so sánh địa chỉ bộ nhớ
        boolean result2 = book1.equals(book2);
        System.out.println("So sánh bằng 'equals' : " + result2); // Kết quả: true -> so sánh các attributes
    }
}