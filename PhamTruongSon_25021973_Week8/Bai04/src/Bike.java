class Bike extends Vehicle {
    public Bike(String plate) { super(plate); }
    @Override
    public double getCharge(int hours) {
        double result = 5;
        if (hours > 3) result += (hours - 3) * 2;
        return result;
    }
    @Override
    public int getBonusPoints(int hours) { return 1; }
}