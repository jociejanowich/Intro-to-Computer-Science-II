public interface AutomationRule{
    boolean shouldActivate(Device device, DeviceContext context);
}