
class SmartSpeaker extends Device implements CanConnectWifi, Adjustable {

    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " speaker is ready");
    }

    @Override
    public void setupWifi() {
        System.out.println(name + " connected to wifi");
    }

    @Override
    public void adjustLevel(int level) {
        System.out.println(name + " volume set to " + level);
    }
}
