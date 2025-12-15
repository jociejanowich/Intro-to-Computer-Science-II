public class LowLightRule implements AutomationRule {
    private final int luxThreshold;


    public LowLightRule(int luxThreshold) {
        this.luxThreshold = luxThreshold;
    }

    @Override
    public boolean shouldActivate(Device device, DeviceContext context) {
    
        if (device instanceof Light) {
            boolean activate = context.lightLevel < luxThreshold;
            System.out.println("LowLightRules: " + device.deviceType() +
                " -> ambientLux: " + context.lightLevel +
                " threshold=: " + luxThreshold +
                " -> " + activate);
            return activate;
        }
        return false;
    }
}