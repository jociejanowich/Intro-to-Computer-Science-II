//concrete light class that extends from device class implementing control capability and network capability 
public class Light extends Device implements ControlCapability, NetworkCapability {
    //variables
    private int brightness;
    private String color;
    //constructor 
    public Light(String name, String id, int brightness, String color){
        super(name, id);
        this.brightness = brightness;
        this.color = color;

    }
    //print that device is turned on by calling control capabilty
    public void turnedOn(){
        System.out.println("Device: " + name + " is turned on.");
    }
    //print that device is turned off by calling control capabilty
    public void turnedOff(){
        System.out.println("Device: " + name + " is turned off.");
    }
    //print that device in connected on by calling sensing capabilty
    public void connect(){
        System.out.println("Device: " + name + " is connected to wifi");
    }
    //print that device in disconnected on by calling sensing capabilty
    public void disconnect(){
        System.out.println("Device: " + name + " is disconnected to wifi");
    }
    //return device type OVERIDE
    public String deviceType(){
        return "Light";
    }

}