//concrete speaker class that extends from device class implementing control capability and network capability
public class Speaker extends Device implements ControlCapability, NetworkCapability{
    //variables
    private int volume;
    //contructor
    public Speaker(String name, String id, int volume){
        super(name, id);
        this.volume = volume;
    }
    //prints device is on by calling control capability
    public void turnedOn(){
        System.out.println("Device: " + name + " is turned on");
    }
    //prints device is off by calling control capability
    public void turnedOff(){
        System.out.println("Device: " + name + " is turned off");
    }
    //prints device is connected by calling control capability
    public void connect(){
        System.out.println("Device: " + name + " is connected to wifi");
    }
    //prints device is disconnected by calling control capability
    public void disconnect(){
        System.out.println("Device: " + name + " is disconnected to wifi");
    }
    //returns device type
    public String deviceType(){
        return "Speaker";
    }
}