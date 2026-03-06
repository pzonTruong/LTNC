public class Inventory {
    private Product[] items;

    public Inventory(Product[] initialProduct){
        this.items = new Product[initialProduct.length];

        for(int i=0; i< initialProduct.length; i++){
            Product p = initialProduct[i];
            this.items[i] = new Product(p.getId(), p.getName(), p.getPrice());
        } // deep copy -> trỏ vào bộ nhớ heap khác -> không thay đổi được giá

        // this.items = initialProduct; : Shallow copy -> chỉ cùng bộ nhớ heap
    }

    public void showItems(){
        for(Product p: items){
            System.out.println(p);
        }
    }
}
