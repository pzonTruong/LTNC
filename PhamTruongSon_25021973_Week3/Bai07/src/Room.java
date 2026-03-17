
abstract class Room {

    protected double basePrice;
    protected int days;

    public Room(double basePrice, int days) {
        this.basePrice = basePrice;
        this.days = days;
    }

    public abstract double getFinalPrice();
}
