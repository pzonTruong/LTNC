public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.addBook("Java Programming", 10);

        // Tạo 3 luồng đọc (Readers)
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                while(true) {
                    store.getStock("Java Programming");
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                }
            }, "Reader-" + i).start();
        }

        // Tạo 2 luồng ghi (Writers)
        new Thread(() -> {
            while(true) {
                store.addBook("Java Programming", 5);
                try { Thread.sleep(3000); } catch (InterruptedException e) {}
            }
        }, "Writer-Nhap").start();

        new Thread(() -> {
            while(true) {
                store.borrow("Java Programming", 2);
                try { Thread.sleep(2500); } catch (InterruptedException e) {}
            }
        }, "Writer-Muon").start();
    }
}