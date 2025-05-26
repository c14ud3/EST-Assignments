# Solution Email Notification System

## Task A
### About the tests
Since the method we should test is a void method, we can't check any return values for correctness. This is why we decided to mock the `EventPublisher` class and assert how many times the `onSatelliteLaunched()` method was called. It should be called exactly once if the parameters are valid. 
So we created a first test case called `testOnSatelliteLaunchedCalledForAllListeners()` which tests with valid parameters and uses a mock to check that the method is called exactly once.
We use a setup and a teardown method to be called for each test to keep the test environment clean and ensure that tests are independent of each other. The setup method creates a mock object of the `EventListener` and spy object for `EventPublisher` and the teardown method resets them to null again.


## Task B
### About the tests
Using a ArgumentCaptor, we capture the arguments passed to the `onSatelliteLaunched()` method. This allowed us to check and assert that the correct parameters are passed to the service. We created a test case called `testOnSatelliteLaunchedContent()` that checks if the parameters are correctly in the Service.

## Task C
### About the tests
In task C to further increase the observability of the `MissionEventProcessor` class, we added a implemetation of the `EventListener` interface called `OberservableListener`. The field receivedEvent is created to store the last event and acts to observe the events passed to it. The `onSatelliteLaunched()` method is overridden to store the event in the variable receivedEvent. The test case `testObservableListenerReceivesCorrectEvent()` checks if the event is correctly passed to the `OberservableListener`.

## Task D
### Advantages in B
ArgumentCaptors allow to capture the arguments passed to a method and verify them.
They are very useful when the method does not return a value. It is also easy to implement using mockito and works very well with existing mocks in mockito. 
The ArgumentCaptor can be defined very specific to check for exact content passed to the method.

### Advantages in C
Using the technique of increasing the observability of the `MissionEventProcessor` class allows to increase the observability by storing received data.
The behavior of the class can be verified without using mocks or spies. 
The actual data flow of the system can be observed which better reflects the real-world behavior of the system.
I can make very complex code a bit easier to test by adding simple getters or checks to the classes. 