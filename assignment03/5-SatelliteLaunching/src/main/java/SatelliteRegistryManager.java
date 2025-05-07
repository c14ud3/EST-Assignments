public class SatelliteRegistryManager implements EventListener {

    @Override
    public void onSatelliteLaunched(LaunchEvent event) {
        System.out.println("Updating Satellite Registry with ID: " + event.getSatelliteId() +
                " and Mission: " + event.getMissionName());
        // Imagine here you would update a real database
    }
}
