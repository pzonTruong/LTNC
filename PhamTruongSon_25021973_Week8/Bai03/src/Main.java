import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // class Vehicle {
        //     protected String plate;
        //     protected String brand;
        //     protected double fuelLevel; // Chỉ xe chạy xăng mới dùng
        //     protected int batteryPercent; // Chỉ xe điện mới dùng
        // }

        // class MotorBike extends Vehicle {
        //     public String getInfo() {
        //         return "Xe máy [" + plate + "] - " + brand;
        //     }

        //     public void refuel(double liters) {
        //         fuelLevel += liters;
        //     }
        // }

        // class Car extends Vehicle {
        //     public String getInfo() {
        //         return "Ô tô [" + plate + "] - " + brand;
        //     }

        //     public void refuel(double liters) {
        //         fuelLevel += liters;
        //     }
        // }

        // class ElectricCar extends Vehicle {
        //     public String getInfo() {
        //         return "Xe điện [" + plate + "] - " + brand;
        //     }

        //     public void charge(int percent) {
        //         batteryPercent += percent;
        //     }
        // }

        // Vấn đề: Lớp cha quá "tham lam" và Lặp code.
        // Vấn đề của fuelLevel và batteryPercent:
        // Lớp Vehicle chứa các thuộc tính mà không phải tất cả các lớp con đều cần. 
        // ElectricCar không có bình xăng nhưng vẫn kế thừa fuelLevel, trong khi MotorBike không có pin nhưng vẫn có batteryPercent. 
        // Điều này làm tốn bộ nhớ và gây nhầm lẫn logic (một xe điện có thể bị gọi hàm đổ xăng)

        // Vấn đề của getInfo()
        // Lặp lại cấu trúc chuỗi " [" + plate + "] - " + brand. 
        // Khi muốn thay đổi định dạng (ví dụ: đổi dấu - thành dấu :), phải sửa ở tất cả các lớp con

        // Tạo danh sách các phương tiện
        List<Vehicle> vehicles = new ArrayList<>();
        
        vehicles.add(new MotorBike("29-A1 12345", "Honda"));
        vehicles.add(new Car("30-F 6789", "Toyota"));
        vehicles.add(new ElectricCar("30-E 5555", "VinFast"));

        // Gọi getInfo() cho tất cả
        System.out.println("List vehicles");
        for (Vehicle v : vehicles) {
            System.out.println(v.getInfo());
        }

        // Kiểm tra tính năng riêng biệt
        System.out.println("\n--- Refuel ---");
        ((GasVehicle) vehicles.get(0)).refuel(5.5);
        ((ElectricVehicle) vehicles.get(2)).charge(20);
    }
}
