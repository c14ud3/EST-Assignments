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

    //Valid strings with common prefixes
    @Property
    void testPropertyLCPPass(@ForAll("validStringArrays") String[] input) {
        String expected = calculateExpectedLCP(input);
        String actual = lcp.lcp(input);
        assertEquals(expected, actual);
    }

    @Provide
    Arbitrary<String[]> validStringArrays() {
        return Arbitraries.strings()
                .alpha()
                .ofMinLength(1)
                .ofMaxLength(10)
                .list()
                .ofMinSize(1)
                .ofMaxSize(10)
                .map(list -> list.toArray(new String[0]));
    }

    //Invalid strings with null elements
    @Property
    void testPropertyLCPFail(@ForAll("invalidStringArrays") String[] input) {
        assertThrows(IllegalArgumentException.class, () -> {
            lcp.lcp(input);
        });
    }
    @Provide
    Arbitrary<String[]> invalidStringArrays() {
        return Arbitraries.strings()
                .ofMinLength(1)
                .ofMaxLength(10)
                .list()
                .ofMinSize(1)
                .ofMaxSize(10)
                .map(list -> {
                    String[] array = list.toArray(new String[0]);
                    array[array.length - 1] = null;
                    return array;
                });
    }

    // Helper
    private String calculateExpectedLCP(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
