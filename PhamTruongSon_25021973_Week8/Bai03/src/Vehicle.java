abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    // Template Method: Cấu trúc chung của thông tin
    public String getInfo() {
        return getVehicleType() + " [" + plate + "] - " + brand;
    }

    // Lớp con bắt buộc phải định nghĩa tên loại xe
    protected abstract String getVehicleType();
}