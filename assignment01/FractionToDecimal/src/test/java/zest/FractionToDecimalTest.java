package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FractionToDecimalTest {
    @ParameterizedTest
    @MethodSource("simpleDivisions")
    void testSimpleDivisions(int numerator, int denominator, String expectedResult) {
        String actual = FractionToDecimal.fractionToDecimal(numerator, denominator);
        assertEquals(expectedResult, actual);
    }

    static Stream<Arguments> simpleDivisions() {
        return Stream.of(
            Arguments.of(1, 1, "1"),
            Arguments.of(1, 2, "0.5"),
            Arguments.of(1, 3, "0.(3)"),
            Arguments.of(1, 0, null),
            Arguments.of(3227, 555, "5.8(144)"),
            Arguments.of(593, 53, "11.(1886792452830)")
        );
    }

    @Test
    void testNumeratorZero() {
        String actual = FractionToDecimal.fractionToDecimal(0, 1);
        assertEquals("0", actual);
    }

    @Test
    void testDenominatorZero() {
        String actual = FractionToDecimal.fractionToDecimal(1, 0);
        assertNull(actual);
    }

    @Test
    void testNumeratorNegative() {
        String actual = FractionToDecimal.fractionToDecimal(-1, 1);
        assertEquals("-1", actual);
    }

    @Test
    void testDenominatorNegative() {
        String actual = FractionToDecimal.fractionToDecimal(1, -1);
        assertEquals("-1", actual);
    }

    @Test
    void testIntegerResult() {
        String actual = FractionToDecimal.fractionToDecimal(9, 3);
        assertEquals("3", actual);
    }

    @Test
    void testFloatingResult() {
        String actual = FractionToDecimal.fractionToDecimal(1, 2);
        assertEquals("0.5", actual);
    }

    @Test
    void testRepeatingResult() {
        String actual = FractionToDecimal.fractionToDecimal(1, 3);
        assertEquals("0.(3)", actual);
    }

    @Test
    void testInstantiation() {
        FractionToDecimal f2d = new FractionToDecimal();
        assertInstanceOf(FractionToDecimal.class, f2d);
    }
}