import java.util.ArrayList;
import java.util.List;
//main method client class
public class SmartHome{
    public static void main(String [] args){
        Light light1 = new Light("Living Room Light", "1234", 50, "Yellow");
        Speaker speaker1 = new Speaker("Porch Speaker", "17273", 75);
        Thermostat thermostat1 = new Thermostat("House Thermostat", "3423", 70);
        Security security1 = new Security("Front door motion camera", "2423", true);
    
        List<Device> allDevices = new ArrayList<>();
        allDevices.add(light1);
        allDevices.add(speaker1);
        allDevices.add(thermostat1);
        allDevices.add(security1);

        System.out.println("*****Device Information*****");
        for (Device d : allDevices){
            d.printInfo();
            System.out.println("Type: " + d.deviceType());
            System.out.println();
        }

        List<ControlCapability> controllables = new ArrayList<>();
        List<NetworkCapability> networkables = new ArrayList<>();
        List<SensingCapability> sensors = new ArrayList<>();

        for (Device d : allDevices){
            if (d instanceof ControlCapability){
                controllables.add((ControlCapability) d);
            }
            if (d instanceof NetworkCapability){
                networkables.add((NetworkCapability) d);
            }
            if (d instanceof SensingCapability){
                sensors.add((SensingCapability) d);
            }

        }


        System.out.println("*****Controllable Devices: turnOn/turnOff*****");
        for (ControlCapability c : controllables) {
            c.turnedOn();
            c.turnedOff();
        }

        System.out.println("\n*****Network-Capable Devices: connect/disconnect*****");
        for (NetworkCapability n : networkables) {
            n.connect();
            n.disconnect();
        }

        System.out.println("\n*****Sensors: readValue/getUnit*****");
        for (SensingCapability s : sensors) {
            boolean detected = s.motionDetected();
            System.out.println("Motion Detected: " + detected);
        }

        System.out.println("\n*****Automation Rules Demo*****");
        DeviceContext morningContext = new DeviceContext("MORNING", 300, 19);
        DeviceContext eveningDarkCold = new DeviceContext("EVENING", 20, 17);

        List<AutomationRule> rules = new ArrayList<>();
        rules.add(new LowLightRule(19));          
        rules.add(new EveningRule());   


        System.out.println("\nApplying rules for EVENING context:");
        applyRulesAndActivate(allDevices, rules, eveningDarkCold);

        
        System.out.println("\nApplying rules for MORNING context:");
        applyRulesAndActivate(allDevices, rules, morningContext);
    }

  
    private static void applyRulesAndActivate(List<Device> allDevices, List<AutomationRule> rules, DeviceContext context) {
     
        List<ControlCapability> controllables = new ArrayList<>();
        List<Device> controllableDevices = new ArrayList<>(); 
        for (Device d : allDevices) {
            if (d instanceof ControlCapability) {
                controllables.add((ControlCapability) d);
                controllableDevices.add(d);
            }
        }

    
        for (int i = 0; i < controllableDevices.size(); i++) {
            Device dev = controllableDevices.get(i);
            ControlCapability controller = controllables.get(i);

            boolean shouldActivate = false;
            for (AutomationRule rule : rules) {
                if (rule.shouldActivate(dev, context)) {
                    shouldActivate = true;
                    break;
                }
            }

            if (shouldActivate) {
                System.out.println(">>> Activating " + dev.deviceType() + " (" + dev.name + ")");
                controller.turnedOn();
            } else {
                System.out.println(">>> Not activating " + dev.deviceType() + " (" + dev.name + ")");
             
                controller.turnedOff();
            }
        }


    }
}