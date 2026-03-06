import java.util.Objects;

public class SmartLight
{
    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness){
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    public SmartLight(String id, String name){
        this.id = id;
        this.name = name;
        this.brightness = 50;
    }

    public void setBrightness(int newBrightness){
        this.brightness = newBrightness;
    }

    public void setBrightness(String preset){
        if (Objects.equals(preset, "MAX")){
            this.brightness = 100;
        } else if (Objects.equals(preset, "MIN")) {
            this.brightness = 10;
        } else if (Objects.equals(preset, "ECO")){
            this.brightness = 30;
        } else {
            System.out.println("Error: Not right format");
        }
    }

    public String getName(){
        return name;
    }

    public void connectToHub(CentralHub hub){
        hub.registerDevice(this);
    }

    public int getBrightness(){
        return brightness;
    }
}
