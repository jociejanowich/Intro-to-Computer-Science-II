public class DeviceContext{
    public final String timeOfDay;
    public final int lightLevel;
    public final int temperatureSetting;
    public DeviceContext(String timeOfDay, int lightLevel, int temperatureSetting){
        this.timeOfDay = timeOfDay;
        this.lightLevel = lightLevel;
        this.temperatureSetting = temperatureSetting;
    }

}