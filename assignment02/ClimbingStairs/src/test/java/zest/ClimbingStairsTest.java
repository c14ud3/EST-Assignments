package zest;


import net.jqwik.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    private final static ClimbingStairs climbingStairs = new ClimbingStairs();

    // --- Working implementation from GeeksForGeeks
    private static int climbStairsRec(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        return memo[n] = climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo);
    }
    private static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsRec(n, memo);
    }
    // ---

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(int n) {
        long expected = climbStairs(n);
        long actual = climbingStairs.climbStairs(n);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(5),
                Arguments.of(8),
                Arguments.of(10),
                Arguments.of(30)
        );
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            climbingStairs.climbStairs(-1);
        });
    }

    @Test
    void testZeroInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            climbingStairs.climbStairs(-1);
        });
    }

    @Property
    void testPropertyNegativeOrZeroInputs(
            @ForAll("negativeNumbers") int n
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            climbingStairs.climbStairs(n);
        });
    }

    @Provide
    private Arbitrary<Integer> negativeNumbers() {
        return Arbitraries.integers().lessOrEqual(0);
    }

    @Property
    void testPropertyPositiveInputs(
            @ForAll("positiveNumbers") int n
    ) {
        long expected = climbStairs(n);
        long actual = climbingStairs.climbStairs(n);
        assertEquals(expected, actual);
    }

    @Provide
    private Arbitrary<Integer> positiveNumbers() {
        return Arbitraries.integers()
                .lessOrEqual(40)
                .greaterOrEqual(1);
    }
}
