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


class ExcelSheetTest {
    private static ExcelSheet excelSheet = new ExcelSheet();

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(String input, long expected) {
        long actual = excelSheet.titleToNumber(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of("A", 1),
                Arguments.of("AB", 28),
                Arguments.of("ZY", 701),
                Arguments.of("AAA", 703)
        );
    }

    @Test
    void testColumnTitleEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            excelSheet.titleToNumber("");
        });
    }

    @Test
    void testColumnTitleTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            excelSheet.titleToNumber("AAAAAAAA");
        });
    }

    @Test
    void testColumnTitleInt() {
        assertThrows(IllegalArgumentException.class, () -> {
            excelSheet.titleToNumber("1");

        });
    }

    @Property
    void testPropertyColumnTitlePass(
            @ForAll("validColumnTitles") String columnTitle
    ) {
        long actual = excelSheet.titleToNumber(columnTitle);
        assertTrue(actual > 0);
    }

    @Provide
    private Arbitrary<String> validColumnTitles() {
        return Arbitraries.strings()
                .ofLength(7)
                .withChars('A', 'B', 'C', 'Z')
                .filter(title -> title.matches("[A-Z]+"));
    }

    @Property
    void testPropertyColumnTitleFail(
            @ForAll("invalidColumnTitles") String columnTitle
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            excelSheet.titleToNumber(columnTitle);
        });
    }

    @Provide
    private Arbitrary<String> invalidColumnTitles() {
        return Arbitraries.strings()
                .ofLength(7)
                .withChars('1', '2', '3', '4', '5')
                .filter(title -> !title.matches("[A-Z]+"));
    }
}
