public class Main {
    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("son");

        customer.addTicket(new ParkingTicket(new Car("30A-123.45"), 4));   // 10 + 2*3 = 16
        customer.addTicket(new ParkingTicket(new Bike("29B-999.99"), 5));  // 5 + 2*2 = 9
        customer.addTicket(new ParkingTicket(new Truck("15C-555.55"), 6)); // 15 + 6*4 = 39, bonus 2

        System.out.println(customer.receipt());
    }
}