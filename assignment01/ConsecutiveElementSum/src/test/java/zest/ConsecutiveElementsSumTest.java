package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ConsecutiveElementsSumTest {
    // Explore program
    @ParameterizedTest
    @MethodSource("simpleNumbers")
    void testSimpleNumbers(int[] numbers, int expectedSum) {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(numbers);
        assertEquals(expectedSum, result);
    }

    static Stream<Arguments> simpleNumbers() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 21),
            Arguments.of(new int[]{0, 0, 0}, 0),
            Arguments.of(new int[]{-1, -1, -1}, -1),
            Arguments.of(new int[]{-1, 1, -1, 1, 0, -1}, 1)
        );
    }

    // Partitions
    @Test
    void testEmptyArray() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void testNullArray() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(null);
        assertEquals(0, result);
    }

    @Test
    void testSinglePositiveElement() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{1});
        assertEquals(1, result);
    }

    @Test
    void testSingleNegativeElement() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{-1});
        assertEquals(-1, result);
    }

    @Test
    void testMultiplePositiveElements() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, result);
    }

    @Test
    void testMultipleNegativeElements() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{-1, -2, -3, -4, -5});
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @MethodSource("multiplePositiveAndNegativeElements")
    void testMultiplePositiveAndNegativeElements(int[] numbers, int expectedSum) {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(numbers);
        assertEquals(expectedSum, result);
    }

    static Stream<Arguments> multiplePositiveAndNegativeElements() {
        return Stream.of(
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6), // 4, -1, 2, 1
            Arguments.of(new int[]{1, 2, -1, 3, 4, -1, 2, 1, -5, 4}, 11), // 1, 2, -1, 3, 4, -1, 2, 1
            Arguments.of(new int[]{-2, 1, 2, 3, -4, 5, 6, -5}, 13) // 1, 2, 3, -4, 5, 6
        );
    }

    // Augmentation
    @Test
    void testSingleZeroElement() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{0});
        assertEquals(0, result);
    }

    @Test
    void testLargeNumberFarAway() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{56, 1, -11, -15, -9, 100});
        assertEquals(122, result);
    }

    // Structural testing
    @Test
    void testTwoElements() {
        int result = ConsecutiveElementsSum.maxConsecutiveSum(new int[]{5, 7});
        assertEquals(12, result);
    }

    @Test
    void testInstantiation() {
        ConsecutiveElementsSum sum = new ConsecutiveElementsSum();
        assertInstanceOf(ConsecutiveElementsSum.class, sum);
    }
}