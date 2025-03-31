package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberEncoderTest {
    @Test
    void testOneDigit(){
        String result = NumberEncoder.encodeNumber("0", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'});
        assertEquals("a", result);
    }

    @Test
    void TestTwoDigits(){
        String result = NumberEncoder.encodeNumber("01", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'});
        assertEquals("ab", result);
    }

    @Test
    void TestNegativeDigit(){
        assertThrows(IllegalArgumentException.class, () -> NumberEncoder.encodeNumber("-1", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}));
    }

    @Test
    void TestNonNumericDigit(){
        assertThrows(IllegalArgumentException.class, () -> NumberEncoder.encodeNumber("a", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}));
    }

    @Test
    void TestSpecialCharacter(){
        assertThrows(IllegalArgumentException.class, () -> NumberEncoder.encodeNumber("!", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}));
    }

    @Test
    void TestDoubleNegativeSign(){
        assertThrows(IllegalArgumentException.class, () -> NumberEncoder.encodeNumber("--1", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}));
    }

    @Test
    void TestShortMappingArray(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> NumberEncoder.encodeNumber("1", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'}));
    }

    @Test
    void TestLongMappingArray(){
        String result = NumberEncoder.encodeNumber("1", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'});
        assertEquals("b", result);
    }

    @Test
    void TestWord(){
        String result = NumberEncoder.encodeNumber("012934956678", new char[]{'E', 'S', 'T', 'i', 's', 'c', 'o', 'l', '!', ' '});
        assertEquals("EST is cool!", result);
    }

    @Test
    void TestEmptyString(){
        String result = NumberEncoder.encodeNumber("", new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'});
        assertEquals("", result);
    }

    @Test
    void TestIntMappingArray(){
        String result = NumberEncoder.encodeNumber("0", new char[]{65, 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'});
        assertEquals("A", result);
    }

    @Test
    void TestNonUniqueMappingArray(){
        String result = NumberEncoder.encodeNumber("0", new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
        assertEquals("a", result);
    }


}