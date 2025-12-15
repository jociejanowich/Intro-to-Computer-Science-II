//concrete thermostat class that extends from device class implementing control capability and network capability
public class Thermostat extends Device implements ControlCapability, NetworkCapability{
    //variables
    private int temperature;
    //constructor
    public Thermostat(String name, String id, int temperature){
        super(name, id);
        this.temperature = temperature;
    }   
    //prints device is on by calling control capability
    public void turnedOn(){
        System.out.println("Device: " + name + " is turned on");
    }
    //prints device is off by calling control capability
    public void turnedOff(){
        System.out.println("Device: " + name + " is turned off");
    }
    //prints device is connected by calling network capability
     public void connect(){
        System.out.println("Device: " + name + " is connected to wifi");
    }
    //prints device is disconnected by calling network capability
     public void disconnect(){
        System.out.println("Device: " + name + " is disconnected to wifi");
    }
    //returns device type
    public String deviceType(){
        return "Thermostat";
    }
}