package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.NotEmpty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RomanToIntegerTest {

    @Test
    void testValidRomanNumerals() {
        RomanToInteger converter = new RomanToInteger();
        assertEquals(1, converter.romanToInt("I"));
        assertEquals(4, converter.romanToInt("IV"));
        assertEquals(9, converter.romanToInt("IX"));
        assertEquals(58, converter.romanToInt("LVIII"));
        assertEquals(1994, converter.romanToInt("MCMXCIV"));
        assertEquals(1666, converter.romanToInt("MDCLXVI"));
        assertEquals(3999, converter.romanToInt("MMMCMXCIX"));
    }

    @Test
    void testZero() {
        RomanToInteger converter = new RomanToInteger();
        assertEquals(0, converter.romanToInt(""));
    }

    // Tests for preconditions:

    @Test
    void testPreconditionValid() {
        RomanToInteger converter = new RomanToInteger();
        assertDoesNotThrow(() -> converter.romanToInt("MDCLXVI"));
    }

    @Test
    void testPreconditionNullInput() {
        RomanToInteger converter = new RomanToInteger();
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt(null),
                "Input string cannot be null");
    }

    @Test
    void testPreconditionInvalidCharacters() {
        RomanToInteger converter = new RomanToInteger();
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("ABCD"),
                "Invalid Roman numeral: A");
    }

    @Test
    void testPreconditionInvalidRepetition() {
        RomanToInteger converter = new RomanToInteger();
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("IIII"),
                "Invalid repetition of numeral: I repeated more than 3 times.");
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("VV"),
                "Invalid repetition of numeral: V can not be repeated.");
    }

    @Test
    void testPreconditionInvalidOrder() {
        RomanToInteger converter = new RomanToInteger();
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("IL"),
                "Invalid order of numerals: IL");
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("IC"),
                "Invalid order of numerals: IC");
    }

    // Tests for postconditions:

    @Test
    void testPostconditionValidMin() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("");
        assertTrue(result >= 0, "Result is negative: " + result);
        assertTrue(result <= 3999, "Result is out of range (greater than 3999): " + result);
    }

    @Test
    void testPostconditionValid() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("MDCLXVI");
        assertTrue(result >= 0, "Result is negative: " + result);
        assertTrue(result <= 3999, "Result is out of range (greater than 3999): " + result);
    }

    @Test
    void testPostconditionValidMax() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("MMMCMXCIX");
        assertTrue(result >= 0, "Result is negative: " + result);
        assertTrue(result <= 3999, "Result is out of range (greater than 3999): " + result);
    }

}

class RomanToIntegerPropertyTest {


    RomanToInteger converter = new RomanToInteger(); // create an instance of the class with the method to be tested

    @Property
    void testRomanToIntegerValidInputValidOutputRange(
            @ForAll("validRomanNumeral") // provide a valid roman numeral
            String roman) {

        int result = converter.romanToInt(roman); // execute the method to be tested

        // Check that the result is an integer between 0 and 3999
        assertTrue(result >= 0 && result <= 3999, "Result is out of range: " + result);
    }

    @Property
    void testRomanToIntegerProportionality(
            @ForAll("validRomanNumeralNotZero") // provide a valid roman numeral greater than zero (contains at least one roman digit)
            String roman) {

        int largerResult = converter.romanToInt(roman); // execute the method with the input numeral that is guaranteed to contain at least one roman digit
        int smallerResult = converter.romanToInt(roman.substring(0, roman.length() - 1)); // execute the method with the input numeral that contains one less digit at the end and thus is smaller

        // Check that the larger result is greater than the smaller result
        assertTrue(largerResult > smallerResult, "Larger roman number gives a smaller result integer than a smaller roman number");
    }

    // Provide a valid roman numeral
    @Provide
    Arbitrary<String> validRomanNumeral() {
        Arbitrary<String> thousands = Arbitraries.strings().ofMinLength(0).ofMaxLength(3).withChars('M'); // choose one of the thousands
        Arbitrary<String> hundreds = Arbitraries.of(
                "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"); // choose one of the hundreds
        Arbitrary<String> tens = Arbitraries.of(
                "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"); // choose one of the tens
        Arbitrary<String> ones = Arbitraries.of(
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"); // choose one of the ones
        // combine the numbers
        return Combinators.combine(thousands, hundreds, tens, ones)
                .as((th, h, t, o) -> th + h + t + o);

    }

    // Provide a valid roman numeral that is greater than 0
    @Provide
    Arbitrary<String> validRomanNumeralNotZero() {
        Arbitrary<String> thousands = Arbitraries.strings().ofMinLength(0).ofMaxLength(3).withChars('M'); // choose one of the thousands
        Arbitrary<String> hundreds = Arbitraries.of(
                "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"); // choose one of the hundreds
        Arbitrary<String> tens = Arbitraries.of(
                "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"); // choose one of the tens
        Arbitrary<String> ones = Arbitraries.of(
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"); // choose one of the ones
        // combine the numbers
        return Combinators.combine(thousands, hundreds, tens, ones)
                .as((th, h, t, o) -> th + h + t + o)
                .filter(s -> !s.isEmpty());
    }

}
