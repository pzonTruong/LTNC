class ElectricCar extends ElectricVehicle {
    public ElectricCar(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getVehicleType() {
        return "Xe điện";
    }
}