package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayElementSwapperTest {
    @Test
    void testEmptyArray() {
        int[] input = new int[]{};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[]{}, input);
    }

    @Test
    void testNullArray() {
        int[] input = null;
        ArrayElementSwapper.swapElements(input);
        assertNull(input);
    }

    @Test
    void testSinglePositiveElementArray() {
        int[] input = new int[] {1};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {1}, input);
    }

    @Test
    void testDualPositiveElementArray() {
        int[] input = new int[] {1, 2};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {1, 2}, input);
    }

    @Test
    void testSingleNegativeElementArray() {
        int[] input = new int[] {-1};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {-1}, input);
    }

    @Test
    void testSingleZeroInElementArray() {
        int[] input = new int[] {1, 0, -1};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {-1, 1, 0}, input);
    }

    @Test
    void testOnlyPositiveNumbers() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, input);
    }

    @Test
    void testOnlyNegativeNumbers() {
        int[] input = new int[] {-1, -2, -3, -4, -5};
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(new int[] {-1, -2, -3, -4, -5}, input);
    }

    @ParameterizedTest
    @MethodSource("multipleMixedNumbers")
    void testMultipleMixedNumbers(int[] input, int[] expected) {
        ArrayElementSwapper.swapElements(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> multipleMixedNumbers() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, new int[] {-1, -2, -3, -4, -5}),
                Arguments.of(new int[] {1, -2, 3, -4, 5}, new int[] {-2, -4, 1, 3, 5}),
                Arguments.of(new int[] {1, -1}, new int[] {-1, 1})
        );
    }

    @Test
    void testInstantiation() {
        ArrayElementSwapper swapper = new ArrayElementSwapper();
        assertInstanceOf(ArrayElementSwapper.class, swapper);
    }
}