public class Main{
    public static void main(){
        Product p1 = new Product(1, "Laptop", 1000.0);
        Product p2 = new Product(2, "Phone", 500.0);
        Product[] arr = {p1, p2};

        Inventory kho = new Inventory(arr);
        System.out.println("Trước khi thay đổi bên ngoài:");
        kho.showItems();

        System.out.println("\nĐang sửa giá Laptop ở mảng bên ngoài thành 5000$...");
        arr[0].setPrice(5000.0);

        System.out.println("\nSau khi thay đổi bên ngoài:");
        kho.showItems();
    }
}