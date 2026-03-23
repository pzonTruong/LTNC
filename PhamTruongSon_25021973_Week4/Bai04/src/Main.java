
interface IData {

    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
// Cố tình KHÔNG ghi public

    // Fixed: thêm 'public' trước hàm show()
    @Override
    public void show() {
        System.out.println("Show Data");
    }
    // bị lỗi: show() in DataManager cannot implement show() in IData attempting to assign weaker access privileges; was public
    // Vì sao? khi cho vào class DataManager, nếu không gán mức truy cập thì hàm sẽ được tự động gán mức default (chỉ
    // cho trong package) -> hẹp hơn mức public -> gây ra lỗi
}

public class Main {
    public static void main(String[] args) {
        DataManager d = new DataManager();
        d.show();
    }
}
