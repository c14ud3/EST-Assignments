package zest;

import java.util.*;

public class EventScheduler {

    public static boolean hasConflict(int[][] events) {
        if (events.length < 2) return false;

        // Sort events by start time
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));

        // Check for overlaps
        for (int i = 0; i < events.length - 1; i++) {
            if (events[i][1] > events[i + 1][0]) {
                return true;
            }
        }
        return false;
    }
}
