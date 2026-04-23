public abstract class Vehicle {
    private String plate;
    public Vehicle(String plate) { this.plate = plate; }
    public String getPlate() { return plate; }
    
    public abstract double getCharge(int hours);
    public abstract int getBonusPoints(int hours);
}