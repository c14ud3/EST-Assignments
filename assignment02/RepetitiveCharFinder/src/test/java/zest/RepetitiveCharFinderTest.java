package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RepetitiveCharFinderTest {
    private static RepetitiveCharFinder finder = new RepetitiveCharFinder();

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(String input, List<Character> expected) {
        List<Character> actual = finder.findNonUniqueCharacters(input);
        assertEquals(expected, actual);
    }
    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of("aabbcc", List.of('a', 'b', 'c')),
                Arguments.of("abcde", List.of()),
                Arguments.of("aabbccddeeff", List.of('a', 'b', 'c', 'd', 'e', 'f')),
                Arguments.of("aA", List.of()),
                Arguments.of("", List.of())
        );
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            finder.findNonUniqueCharacters(null);
        });
    }

    @Test
    void testEmptyInput() {
        List<Character> result = finder.findNonUniqueCharacters("");
        assertTrue(result.isEmpty());
    }

    //Test for input with non-unique characters.
    @Property
    void testPropertyNonUniqueCharacters(
            @ForAll("nonUniqueStrings") String input
    ) {
        List<Character> result = finder.findNonUniqueCharacters(input);
        assertFalse(result.isEmpty());
        for (Character c : result) {
            assertTrue(input.indexOf(c) != input.lastIndexOf(c));
        }
    }

    @Provide
    Arbitrary<String> nonUniqueStrings() {
        return Arbitraries.strings()
                .ofLength(100)
                .map(s -> s + s.charAt(0)); // Ensures at least one non-unique character
    }

    //Input with distinct characters
    @Property
    void testPropertyUniqueCharacters(
            @ForAll("uniqueStrings") String input
    ) {
        List<Character> result = finder.findNonUniqueCharacters(input);
        assertTrue(result.isEmpty());
    }

    @Provide
    Arbitrary<String> uniqueStrings() {
        return Arbitraries.strings()
                .ofLength(100)
                .map(s -> s.chars().distinct().mapToObj(c -> (char) c).collect(Collectors.toList()))
                .map(chars -> chars.stream().map(String::valueOf).collect(Collectors.joining()));
    }


}
