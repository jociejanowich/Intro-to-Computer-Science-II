//shared abstract class DEVICE
public abstract class Device{
    //variables
    protected String name;
    protected String id;

    //constructor
    public Device(String name, String id){
        this.name = name;
        this.id = id;
    }
    //print information method that prints device name and id
    public void printInfo(){
        System.out.println("Device Name: " + name + "ID: " + id);
    }
    //call to device type
    public abstract String deviceType();

}

