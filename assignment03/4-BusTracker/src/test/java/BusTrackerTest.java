import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BusTrackerTest {
    GPSDeviceService gpsService;
    MapService mapService;
    NotificationService notificationService;
    BusTracker busTracker;

    @BeforeEach
    void setup() {
        gpsService = mock(GPSDeviceService.class);
        mapService = mock(MapService.class);
        notificationService = mock(NotificationService.class);

        busTracker = new BusTracker(gpsService, mapService, notificationService);
    }

    // * A. Accuracy of Location Updates
    // check that the map is correctly updated
    @Test
    void testMapUpdate() {
        // provide locations for bus 1 & 2
        Location locationBus1 = new Location(1, 2, true, "IKEA");
        Location locationBus2 = new Location(3, 4, false, null);

        when(gpsService.getCurrentLocation("bus1")).thenReturn(locationBus1);
        when(gpsService.getCurrentLocation("bus2")).thenReturn(locationBus2);

        // call the update function for both buses
        busTracker.updateBusLocation("bus1");
        busTracker.updateBusLocation("bus2");

        // check if the map has been updated
        verify(mapService).updateMap("bus1", locationBus1);
        verify(mapService).updateMap("bus2", locationBus2);
    }

    // * B. Notification of Key Events
    // check that the notification is correctly sent to the passengers
    @Test
    void testNotificationSent() {
        // provide location
        Location locationBus = new Location(1, 2, true, "IKEA");

        when(gpsService.getCurrentLocation("bus1")).thenReturn(locationBus);

        // call the update function for both buses
        busTracker.updateBusLocation("bus1");

        // * verify that a message has been sent
        // build argument captors
        ArgumentCaptor<String> captorBusId = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> captorMessage = ArgumentCaptor.forClass(String.class);

        verify(notificationService, times(1)).notifyPassengers(captorBusId.capture(), captorMessage.capture());

        String busId = captorBusId.getValue();
        String message = captorMessage.getValue();

        assertEquals("bus1", busId);
        assertTrue(message.contains("The bus has arrived at"));
        assertTrue(message.contains("IKEA"));
    }

    // check that no notification is sent, if there's no waypoint
    @Test
    void testNotificationNotSent() {
        // provide location
        Location locationBus = new Location(3, 4, false, null);

        when(gpsService.getCurrentLocation("bus1")).thenReturn(locationBus);

        // call the update function for both buses
        busTracker.updateBusLocation("bus1");

        // * verify that no message has been sent for bus1
        verify(notificationService, times(0)).notifyPassengers(anyString(), anyString());

    }

    // * C. Response to GPS Signal Loss
    // correctly handle a GPS failure
    @Test
    void testGPSFailure() {
        // provide null as bus location
        when(gpsService.getCurrentLocation(anyString())).thenReturn(null);

        // call to function
        busTracker.updateBusLocation("bus1");

        // test that correct message is provided to passengers
        verify(notificationService, times(1))
                .notifyPassengers("bus1", "GPS signal lost. Please check back later.");
    }
}

