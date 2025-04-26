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
    void testSimpleExamples(String input, int expected) {
        int actual = excelSheet.titleToNumber(input);
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
}

