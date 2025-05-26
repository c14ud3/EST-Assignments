import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventPublisherTest {

    private EventPublisher publisher;
    private EventListener listener1;
    private EventListener listener2;

    @BeforeEach
    void setUp() {
        publisher = spy(new EventPublisher());
        listener1 = mock(EventListener.class);
        listener2 = mock(EventListener.class);
        publisher.subscribe(listener1);
        publisher.subscribe(listener2);
    }

    @AfterEach
    void tearDown() {
        publisher = null;
        listener1 = null;
        listener2 = null;
    }

    @Test
    void testOnSatelliteLaunchedCalledForAllListeners() {
        LaunchEvent event = new LaunchEvent("1", "UZH Mission");
        publisher.publishSatelliteLaunched(event);

        verify(listener1, times(1)).onSatelliteLaunched(event);
        verify(listener2, times(1)).onSatelliteLaunched(event);
    }

    @Test
    void testOnSatelliteLaunchedReceivesCorrectEventDetails() {
        LaunchEvent event = new LaunchEvent("2", "ETH Mission");
        publisher.publishSatelliteLaunched(event);

        ArgumentCaptor<LaunchEvent> captor = ArgumentCaptor.forClass(LaunchEvent.class);
        verify(listener1).onSatelliteLaunched(captor.capture());
        LaunchEvent captured = captor.getValue();
        assertEquals("2", captured.getSatelliteId());
        assertEquals("ETH Mission", captured.getMissionName());
    }

    static class ObservableListener implements EventListener {
        LaunchEvent receivedEvent;
        @Override
        public void onSatelliteLaunched(LaunchEvent event) {
            this.receivedEvent = event;
        }
    }

    @Test
    void testObservableListenerReceivesCorrectEvent() {
        ObservableListener obsListener = new ObservableListener();
        publisher.subscribe(obsListener);

        LaunchEvent event = new LaunchEvent("3", "ZHAW Mission");
        publisher.publishSatelliteLaunched(event);

        assertNotNull(obsListener.receivedEvent);
        assertEquals("3", obsListener.receivedEvent.getSatelliteId());
        assertEquals("ZHAW Mission", obsListener.receivedEvent.getMissionName());
    }
}