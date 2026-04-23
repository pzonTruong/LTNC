public class ParkingTicket {
    private Vehicle vehicle;
    private int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public double getAmount() { return vehicle.getCharge(hours); }
    public int getBonusPoints() { return vehicle.getBonusPoints(hours); }
    public String getPlate() { return vehicle.getPlate(); }
}