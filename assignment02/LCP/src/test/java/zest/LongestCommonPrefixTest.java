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

class LongestCommonPrefixTest {
    private static LongestCommonPrefix lcp = new LongestCommonPrefix();

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(String[] input, String expected) {
        String actual = lcp.lcp(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of(new String[] {"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[] {"dog", "racecar", "car"}, ""),
                Arguments.of(new String[] {"a"}, "a"),
                Arguments.of(new String[] {}, ""),
                Arguments.of(new String[] {"", ""}, "")
        );
    }

    @Test
    void testSingleString() {
        String[] input = {"single"};
        String expected = "single";
        String actual = lcp.lcp(input);
        assertEquals(expected, actual);
    }
}
