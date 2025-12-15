//concrete security camera class that extends from device class implementing network, control, and sensing capability
public class Security extends Device implements NetworkCapability, ControlCapability, SensingCapability{
    //variables
    private boolean motion;
    //constructor
    public Security(String name, String id, boolean motion){
        super(name, id);
        this.motion = motion;
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
    public boolean motionDetected(){
        if (motion){
            System.out.println("Device: " + name + " detected motion");
            return true;
        }
        else{
            System.out.println("Device: " + name + " has not detected motion");
            return false;
        }
    }
    public String deviceType(){
        return "Security";
    }
}