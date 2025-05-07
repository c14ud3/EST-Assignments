import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    private final List<EventListener> listeners = new ArrayList<>();

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void publishSatelliteLaunched(LaunchEvent event) {
        for (EventListener listener : listeners) {
            listener.onSatelliteLaunched(event);
        }
    }
}

