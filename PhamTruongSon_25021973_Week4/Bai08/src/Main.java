
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            switch (type) {
                case "L" ->
                    devices.add(new SmartLight(id, name));
                case "AC" ->
                    devices.add(new AirConditioner(id, name));
                case "S" ->
                    devices.add(new SmartSpeaker(id, name));
                case "C" ->
                    devices.add(new Curtain(id, name));
            }
        }

        System.out.println("\nTurn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
        }

        System.out.println("\nSetup Wifi:");
        for (Device d : devices) {
            // Check ket noi wifi
            if (d instanceof CanConnectWifi) {
                ((CanConnectWifi) d).setupWifi();
            }
        }

        sc.close();
    }
}
