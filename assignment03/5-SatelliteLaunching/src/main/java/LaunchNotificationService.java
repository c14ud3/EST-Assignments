public class LaunchNotificationService implements EventListener {

    @Override
    public void onSatelliteLaunched(LaunchEvent event) {
        System.out.println("Sending launch notification for Satellite ID: " + event.getSatelliteId() +
                " Mission: " + event.getMissionName());
        // Assume here you would send an actual email or alert
    }
}
