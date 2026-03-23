import java.util.*;

// T extends Product: Đảm bảo T chỉ có thể là Food, Electronic hoặc các lớp con của Product
class Warehouse<T extends Product> {
    private String warehouseName;
    private List<T> storage = new ArrayList<>();

    public Warehouse(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void addProduct(T product) {
        storage.add(product);
        System.out.println("Đã nhập kho: " + product.name);
    }

    public void removeProduct(String id) {
        storage.removeIf(p -> p.id.equals(id));
    }

    public void showInventory() {
        System.out.println("\n--- KIỂM KÊ KHO: " + warehouseName.toUpperCase() + " ---");
        for (T item : storage) {
            System.out.println(item);
        }
    }
}