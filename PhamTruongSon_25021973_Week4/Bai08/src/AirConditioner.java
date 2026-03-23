
public class AirConditioner extends Device implements CanConnectWifi {

    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " AC is cooling");
    }

    @Override
    public void setupWifi() {
        System.out.println(name + " connected to wifi");
    }
}
