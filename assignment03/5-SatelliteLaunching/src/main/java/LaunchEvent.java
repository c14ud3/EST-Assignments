public class LaunchEvent {
    private final String satelliteId;
    private final String missionName;

    public LaunchEvent(String satelliteId, String missionName) {
        this.satelliteId = satelliteId;
        this.missionName = missionName;
    }

    public String getSatelliteId() {
        return satelliteId;
    }

    public String getMissionName() {
        return missionName;
    }
}
