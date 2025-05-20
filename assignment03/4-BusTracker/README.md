#BusTracker

The `BusTracker` class manages the real-time locations of buses as they move throughout a city. The system integrates with a `GPSDeviceService` to receive live location data from buses and a `MapService` to update the positions on a public-facing map. Additionally, when a bus reaches certain key waypoints or stations, it triggers notifications to passengers via the `NotificationService`.

Write *unit tests* for the `updateBusLocation` method of the `BusTracker` class using test doubles for the GPS and map services.

Specifically, implement tests that cover the following scenarios:

### A. Accuracy of Location Updates
First, verify that the `updateBusLocation` method accurately updates the bus's location on the map when new data is received.

### B. Notification of Key Events
Test if the system correctly triggers notifications when buses arrive at key waypoints. Use `ArgumentCaptor` from `Mockito` to capture the details of arguments passed to the `NotificationService` (Instead of just verifying that `NotificationService` was called, verify what values it was called with).


### C.  Response to GPS Signal Loss
Implement tests that simulate the loss of the GPS signal to see how the system handles failures or interruptions in data.


Automate the test cases using the **JUnit5** plugin.

