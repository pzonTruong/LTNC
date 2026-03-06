public class Main{
    public static void main(){
        CentralHub hub = new CentralHub();

        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);
        SmartLight l2 = new SmartLight("L02", "Đèn ngủ");
        l2.setBrightness("ECO");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("\n--- THÔNG TIN ĐÈN ---");
        System.out.println(l1.getName() + " - Độ sáng: " + l1.getBrightness());
        System.out.println(l2.getName() + " - Độ sáng: " + l2.getBrightness());
    }
}