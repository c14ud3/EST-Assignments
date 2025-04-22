package zest;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BitwiseSumCalculatorTest {
    @Test
    void testInstantiate() {
        BitwiseSumCalculator calculator = new BitwiseSumCalculator();
        assertNotNull(calculator);
    }

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(int a, int b, int expected) {
        int actual = BitwiseSumCalculator.getSum(a, b);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, -2, -1),
                Arguments.of(-1, 2, 1),
                Arguments.of(0, 0, 0)
        );
    }

    @Property
    void testOutputSum(
            @ForAll @IntRange() int a,
            @ForAll @IntRange() int b
    ) {
        int actual = BitwiseSumCalculator.getSum(a, b);
        int expected = a + b;
        assertEquals(expected, actual);
    }
}

