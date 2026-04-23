

public abstract class Order {
    protected double weight;
    protected double distance;

    public Order(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    // Các phương thức trừu tượng buộc lớp con phải triển khai
    public abstract double getDeliveryFee();
    public abstract String getLabel();
}