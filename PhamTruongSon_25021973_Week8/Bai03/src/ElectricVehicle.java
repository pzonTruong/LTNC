abstract class ElectricVehicle extends Vehicle {
    protected int batteryPercent;

    public ElectricVehicle(String plate, String brand) {
        super(plate, brand);
    }

    public void charge(int percent) {
        this.batteryPercent = Math.min(100, this.batteryPercent + percent);
        System.out.println("Charging " + percent + "%. Curr battery: " + batteryPercent + "%");
    }
}