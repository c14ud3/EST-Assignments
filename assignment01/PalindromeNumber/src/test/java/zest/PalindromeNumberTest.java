package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class PalindromeNumberTest {
    @ParameterizedTest
    @MethodSource("testCases")
    void testMultipleIntegers(int input){
        assertTrue(PalindromeNumber.isPalindrome(input));
    }
    static Stream<Arguments> testCases(){
        return Stream.of(
            Arguments.of(0),
            Arguments.of(1),
            Arguments.of(5),
            Arguments.of(11),
            Arguments.of(121),
            Arguments.of(111),
            Arguments.of(122222221),
            Arguments.of(214747412),
            Arguments.of(2147447412)
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesFalse")
    void testCasesFalse(int input){
        assertFalse(PalindromeNumber.isPalindrome(input));
    }
    static Stream<Arguments> testCasesFalse(){
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(-11),
            Arguments.of(-121),
            Arguments.of(-11111),
            Arguments.of(Integer.MIN_VALUE),
            Arguments.of(10),
            Arguments.of(87),
            Arguments.of(178),
            Arguments.of(214747413),
            Arguments.of(Integer.MAX_VALUE),
            Arguments.of(1711)

        );
    }


}

