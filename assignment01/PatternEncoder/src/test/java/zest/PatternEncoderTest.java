package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternEncoderTest {
    @Test // test case 1
    void testEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 2
    void testSingleCharacter() {
        String input = "a";
        String expected = "a";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 3
    void testNoRepetition() {
        String input = "abc";
        String expected = "abc";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 4
    void testSingleCharacterRepeatedOnce() {
        String input = "aa";
        String expected = "2[a]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 5
    void testMultipleCharactersRepeatedOnce() {
        String input = "aabb";
        String expected = "2[a]2[b]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 6
    void testSingleCharacterRepeatedMoreThanOnce() {
        String input = "aaa";
        String expected = "3[a]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 7
    void testMultipleCharactersRepeatedMoreThanOnce() {
        String input = "aaabbb";
        String expected = "3[a]3[b]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 8
    void testSingleSubstringRepeatedOnce() {
        String input = "abab";
        String expected = "2[ab]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 9
    void testSingleSubstringRepeatedMoreThanOnce() {
        String input = "ababab";
        String expected = "3[ab]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 10
    void testMultipleSubstringsRepeatedMoreThanOnce() {
        String input = "abababxyzxyz";
        String expected = "3[ab]2[xyz]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 11
    void testNestedRepetitionSingleSubstring() {
        String input = "ababcababc";
        String expected = "2[2[ab]c]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 12
    void testNestedRepetitionMultipleSubstrings() {
        String input = "ababcababcxyzxyz";
        String expected = "2[2[ab]c]2[xyz]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

}