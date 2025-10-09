public class EveningRule implements AutomationRule {
    private final int tempThresholdC = 19; 

    @Override
    public boolean shouldActivate(Device device, DeviceContext context) {
        if ("EVENING".equalsIgnoreCase(context.timeOfDay) && device instanceof Thermostat) {
            boolean activate = context.temperatureSetting < tempThresholdC;
            System.out.println("EveningRule: " + device.deviceType() +
                " -> timeOfDay: " + context.timeOfDay +
                ", temperature: " + context.temperatureSetting +
                ", threshold: " + tempThresholdC +
                " -> " + activate);
            return activate;
        }
        return false;
    }
}
