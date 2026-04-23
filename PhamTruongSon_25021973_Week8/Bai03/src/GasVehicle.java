abstract class GasVehicle extends Vehicle {
    protected double fuelLevel;

    public GasVehicle(String plate, String brand) {
        super(plate, brand);
    }

    public void refuel(double liters) {
        this.fuelLevel += liters;
        System.out.println("Refuel:  " + liters + " liter.");
    }
}