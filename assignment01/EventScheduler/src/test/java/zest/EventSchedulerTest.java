package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EventSchedulerTest {
    @ParameterizedTest
    @MethodSource("simpleEvents")
    void testSimpleEvents(int[][] events, boolean expected) {
        boolean actual = EventScheduler.hasConflict(events);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleEvents() {
        return Stream.of(
            Arguments.of(new int[][] {{2, 4}, {3, 5}}, true),
            Arguments.of(new int[][] {{2, 4}, {5, 7}}, false)
        );
    }

    @Test
    void testEmptyEvents1() {
        int[][] events = {};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testEmptyEvents2() {
        int[][] events = {{}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testNullArray() {
        int[][] events = {null};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testOnlyOneEvent() {
        int[][] events = {{2, 4}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testMultipleEventsNotOverlapping() {
        int[][] events = {{2, 4}, {5, 7}, {8, 10}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testMultipleEventsTouching() {
        int[][] events = {{1, 2}, {2, 3}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testMultipleEventsOverlapping() {
        int[][] events = {{2, 4}, {3, 5}, {8, 10}};
        boolean actual = EventScheduler.hasConflict(events);
        assertTrue(actual);
    }

    @Test
    void testTooFewIntegers() {
        int[][] events = {{2}, {3}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testTooManyIntegers() {
        int[][] events = {{2, 4, 6}, {3, 5, 7}};
        boolean actual = EventScheduler.hasConflict(events);
        assertFalse(actual);
    }

    @Test
    void testInstantiation() {
        EventScheduler scheduler = new EventScheduler();
        assertInstanceOf(EventScheduler.class, scheduler);
    }

    @Test
    void testArraySorting() {
        int[][] events = {{3, 5}, {2, 4}};
        EventScheduler.hasConflict(events);
        assertArrayEquals(new int[][] {{2, 4}, {3, 5}}, events);
    }
}