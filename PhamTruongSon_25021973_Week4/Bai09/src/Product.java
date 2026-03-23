
abstract class Product {

    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Mỗi loại hàng hóa sẽ có cách hiển thị thông tin kiểm kê khác nhau
    public abstract String getInventoryDetails();

    @Override
    public String toString() {
        return id + " - " + name + " | " + getInventoryDetails();
    }
}
