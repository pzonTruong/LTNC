class Truck extends Vehicle {
    public Truck(String plate) { super(plate); }
    @Override
    public double getCharge(int hours) {
        return 15 + hours * 4;
    }
    @Override
    public int getBonusPoints(int hours) {
        return (hours > 5) ? 2 : 1;
    }
}