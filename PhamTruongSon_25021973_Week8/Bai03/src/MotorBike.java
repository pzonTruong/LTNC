class MotorBike extends GasVehicle {
    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getVehicleType() {
        return "Xe máy";
    }
}