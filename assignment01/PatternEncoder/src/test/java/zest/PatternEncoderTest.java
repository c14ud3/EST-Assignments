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
    void testRepeatedSubstring() {
        String input = "abcabc";
        String expected = "abcabc"; // not "2[abc]"
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 9
    void testSubstringAtBeginning() {
        String input = "aaabc";
        String expected = "3[a]bc";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 10
    void testSubstringInMiddle() {
        String input = "abcaab";
        String expected = "abc2[a]b";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 11
    void testSubstringAtEnd() {
        String input = "abcaaa";
        String expected = "abc3[a]";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 12
    void testMultipleSubstrings() {
        String input = "abbbcddde";
        String expected = "a3[b]c3[d]e";
        assertEquals(expected, PatternEncoder.encodeString(input));
    }

    @Test // test case 13
    void testNull() {
        String input = null;
        String expected = null;
        assertEquals(expected, PatternEncoder.encodeString(input));
    }



}