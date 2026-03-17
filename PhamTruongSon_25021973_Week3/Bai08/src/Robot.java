interface Flyable { void fly(); }
interface Swimmable { void swim(); }
interface GPS { void getCoordinates(); }
interface ElectronicDevice { void turnOn(); }

abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName){
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery(){
        this.batteryLevel = 100;
    }

    // ko cho lop con ghi de -> dung final
    public final void showIdentity(){
        System.out.println("ID: " + id + " |Model: " + modelName);
    }

    public String getModelName(){
        return modelName;
    }

    // abstract method
    public abstract void performMainTask();
}
