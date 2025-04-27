package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRotatorTest {
    private static ArrayRotator arrayRotator = new ArrayRotator();

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(int[] input, int rotation, int[] expected) {
        int[] actual = arrayRotator.rotate(input, rotation);
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 1, new int[] {5, 1, 2, 3, 4}),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, 1, new int[] {-5, -1, -2, -3, -4}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 0, new int[] {1, 2, 3, 4, 5}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 5, new int[] {1, 2, 3, 4, 5})
        );
    }

    @Test
    void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayRotator.rotate(new int[] {}, 1);
        });
    }

    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayRotator.rotate(null, 1);
        });
    }

    @Test
    void testNegativeRotationCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayRotator.rotate(new int[] {1,2,3}, -1);
        });
    }

    // Rotate the array by an arbitrary integer
    @Property
    void testPropertyRotationCountPass(
            @ForAll @IntRange(min = 0) int rotationCount
    ) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] returnedArray = arrayRotator.rotate(originalArray, rotationCount);
        Arrays.sort(returnedArray);
        assertArrayEquals(originalArray, returnedArray);
    }

    // Rotate the array by an invalid integer
    @Property
    void testPropertyRotationCountFail(
            @ForAll("invalidRotationCounts") int rotationCount
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayRotator.rotate(new int[] {1, 2, 3, 4, 5}, rotationCount);
        });
    }

    @Provide private Arbitrary<Integer> invalidRotationCounts() {
        return Arbitraries.integers().lessOrEqual(-1);
    }

    // Rotate an arbitrary array by 1
    @Property
    void testPropertyOriginalArrayPass(
            @ForAll @IntRange() int int1,
            @ForAll @IntRange() int int2,
            @ForAll @IntRange() int int3
    ) {
        int[] originalArray = {int1, int2, int3};
        int[] returnedArray = arrayRotator.rotate(originalArray, 1);
        assertArrayEquals(new int[] {int3, int1, int2}, returnedArray);
    }
}
