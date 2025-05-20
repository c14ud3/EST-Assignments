# SatelliteLaunching


A space mission control system must perform two actions after a satellite launch event occurs.
First, it updates the `SatelliteRegistry` database because the launched satellite must now be tracked officially; this task is handled by the `SatelliteRegistryManager` class.

Second, it sends launch success notifications to engineers; this is handled by the `LaunchNotificationService` class.
Both classes implement the `EventListener` interface, which defines the `onSatelliteLaunched` method. This method is called after a satellite is launched.
For this to happen, these classes subscribe to the `EventPublisher` class, which is responsible for invoking `onSatelliteLaunched` on each listener.
Click [here](https://en.wikipedia.org/wiki/Observer_pattern) if you want to learn more about the *Observer* pattern (not mandatory for the assignment).


Write unit tests for the `publishSatelliteLaunched` method of the `EventPublisher` class using test doubles instead of the real implementations of the `LaunchNotificationService` and the `SatelliteRegistryManager`, after refactoring the code accordingly if needed.
Specifically, implement tests that cover the following scenarios:

### A. Number of invocations
First, test if the `onSatelliteLaunched` method is called as many times as expected. 
To do this, create a spy of the EventPublisher class so that you can verify interactions with it during the test.


### B. Content of invocations—`ArgumentCaptor`
Simply counting the invocations may not be enough; additionally, test if the details of the satellite launch (such as satellite ID, mission name) are correctly passed to the services. Use `ArgumentCaptor` to capture and verify these details.


### C. Content of invocations—Increasing observability
Instead of using `ArgumentCaptor`, you could increase the observability of the `MissionEventProcessor` class to achieve the same goal.
Implement the necessary changes to improve observability and write additional tests to verify that the contents of the launch event messages are correct.


### D. Advantages
What are the advantages of the techniques you used in B. and C.?


Automate the test cases using the **JUnit5** plugin.
