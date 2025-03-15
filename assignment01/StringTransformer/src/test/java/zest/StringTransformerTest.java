package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformerTest {
    @Test // test case 1
    void testEmptyInputs() {
        String start = "";
        String target = "";
        int expected = 0;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 2
    void testEmptyStartSingleCharTarget() {
        String start = "";
        String target = "a";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 3
    void testSingleCharStartEmptyTarget() {
        String start = "a";
        String target = "";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 4
    void testSingleCharStartSingleCharTarget() {
        String start = "a";
        String target = "b";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 5
    void testMultipleCharsStartMultipleCharsTarget() {
        String start = "abc";
        String target = "yabd";
        int expected = 2;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 6
    void testSpecialCharsStartSpecialCharsTarget() {
        String start = "a!@#";
        String target = "!@#a";
        int expected = 2;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 7
    void testEscapeCharsStartEscapeCharsTarget() {
        String start = "a\nb";
        String target = "ab\n";
        int expected = 2;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 8
    void testEqualStrings() {
        String start = "abc";
        String target = "abc";
        int expected = 0;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 9
    void testOneInsertOperation() {
        String start = "abc";
        String target = "abxc";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 10
    void testOneReplaceOperation() {
        String start = "abc";
        String target = "axc";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }

    @Test // test case 11
    void testOneDeleteOperation() {
        String start = "abc";
        String target = "ac";
        int expected = 1;
        assertEquals(expected, StringTransformer.minOperations(start, target));
    }
}
