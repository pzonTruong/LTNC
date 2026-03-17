public class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice{
    public DroneRobot(int id, String modelName){
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " perform main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting cordinates");
    }

    @Override
    public void turnOn() {
        System.out.println("Drone " + getModelName() + " powered on");
    }
}
