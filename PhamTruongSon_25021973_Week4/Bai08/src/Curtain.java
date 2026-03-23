
class Curtain extends Device {

    public Curtain(String id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " curtain opened");
    }
}
