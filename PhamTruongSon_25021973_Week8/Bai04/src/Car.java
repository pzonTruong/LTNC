public class Car extends Vehicle {
    public Car(String plate) { super(plate); }
    @Override
    public double getCharge(int hours) {
        return 10 + (hours > 2 ? (hours - 2) * 3 : 0);
    }
    @Override
    public int getBonusPoints(int hours) { return 1; }
}