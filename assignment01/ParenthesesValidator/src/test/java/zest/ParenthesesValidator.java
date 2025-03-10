package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesesValidatorTest {

    @Test // test case 1
    void testEmptyStringValid() {
        String input = "";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 2
    void testSingleTypeValid() {
        String input = "((()))";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 3
    void testNoNestedBracketsValid() {
        String input = "()()()";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 4
    void testFirstHalfOpeningSecondHalfClosingValid() {
        String input = "((()))";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 5
    void testSingleTypeNoNestedBracketsValid() {
        String input = "()()()";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 6
    void testSingleTypeFirstHalfOpeningSecondHalfClosingValid() {
        String input = "((()))";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 7
    void testValidSequence() {
        String input = "{[()]}";
        assertTrue(ParenthesesValidator.isValid(input));
    }

    @Test // test case 8
    void testOneOpeningBracketMissing() {
        String input = "())";
        assertFalse(ParenthesesValidator.isValid(input));
    }

    @Test // test case 9
    void testOneClosingBracketMissing() {
        String input = "(()";
        assertFalse(ParenthesesValidator.isValid(input));
    }

    @Test // test case 10
    void testOneOpeningBracketChangedToClosing() {
        String input = "())";
        assertFalse(ParenthesesValidator.isValid(input));
    }

    @Test // test case 11
    void testOneClosingBracketChangedToOpening() {
        String input = "(((";
        assertFalse(ParenthesesValidator.isValid(input));
    }

    @Test // test case 12
    void testOneOpeningBracketChangedToDifferentType() {
        String input = "{(})";
        assertFalse(ParenthesesValidator.isValid(input));
    }

    @Test // test case 13
    void testOneClosingBracketChangedToDifferentType() {
        String input = "{[)]}";
        assertFalse(ParenthesesValidator.isValid(input));
    }

 
}