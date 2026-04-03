abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name){
        this.id = id;
        this.name = name;
        this.isOn = false;
    }

    public void turnOff(){
        this.isOn = false;
        System.out.println(name + " turned off.");
    }

    public abstract void turnOn(); // Mỗi thiết bị bật mỗi kiểu khác nhau
}