public class Product
{
    private String name;
    private double price;
    private int quantity;
    private double discount;

    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount){
        this.name =name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;

    }

    public static void updateTaxRate(double newRate){
        Product.taxRate = newRate;
    }

    public double calculateFinalPrice(){
        return (this.price - this.discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount){
        this.discount = newDiscount;
    }

    public void sell(int amount){
        if (amount <= quantity){
            this.quantity -= amount;
            Product.totalRevenue += amount * calculateFinalPrice();
            System.out.println("Total: " +  totalRevenue);
        } else{
            System.err.println("Khong du hang trong kho");
        }
    }

    public static double getTotalRevenue(){
        return totalRevenue;
    }
}
