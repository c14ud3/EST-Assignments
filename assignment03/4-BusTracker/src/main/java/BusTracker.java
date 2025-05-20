public class BusTracker {
    private GPSDeviceService gpsService;
    private MapService mapService;
    private NotificationService notificationService;

    //Constructor: creates a BusTracker object using three dependencies passed from outside
    public BusTracker(GPSDeviceService gpsService, MapService mapService, NotificationService notificationService) {
        this.gpsService = gpsService;
        this.mapService = mapService;
        this.notificationService = notificationService;
    }
    //update new location of the bus on the map
    public void updateBusLocation(String busId) {
        Location newLocation = gpsService.getCurrentLocation(busId);
        if (newLocation != null) {
            mapService.updateMap(busId, newLocation);
            if (newLocation.isKeyWaypoint()) {
                notificationService.notifyPassengers(busId, "The bus has arrived at " + newLocation.getWaypointName());
            }
        } else {
            handleGPSFailure(busId);
        }
    }

    private void handleGPSFailure(String busId) {
        notificationService.notifyPassengers(busId, "GPS signal lost. Please check back later.");
    }
}
