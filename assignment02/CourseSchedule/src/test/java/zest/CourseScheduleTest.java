package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pitest.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {
    private static CourseSchedule scheduler = new CourseSchedule();

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(int numCourses, int[][] prerequisites, boolean expected) {
        boolean actual = scheduler.canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> simpleExamples(){
        return Stream.of(
                Arguments.of(1, new int[][] {}, true),
                Arguments.of(2, new int[][] {{1, 0}, {0, 1}}, false),
                Arguments.of(2, new int[][] {{1, 0}}, true),
                Arguments.of(3, new int[][] {{2, 1}, {2, 0}, {1, 0}}, true)

        );


    }

    @Test
    void testCoursesZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(0, new int[][] {});
        });
    }

    @Test
    void testCoursesNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(-1, new int[][] {});
        });
    }

    @Test
    void testCourseLarger64(){
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(65, new int[][] {});
        });
    }

    @Test
    void testPrerequisitesLarger64(){
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(2, new int[][] {{1, 0}, {1, 0}, {1, 0}, {1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0},{1, 0}, {1, 0}});
        });
    }

    @Test
    void testValidPrerequisites(){
        boolean actual = scheduler.canFinish(2, new int[][] {{1, 0}, {1,0}});
        assertEquals(true, actual);
    }


    @Test
    void testPrerequisitesNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(2, new int[][] {{1, -1}});
        });
    }

    @Test
    void testPrerequisitesLargerNumCourses(){
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(2, new int[][] {{1, 2}});
        });
    }

    @Test
    void testPrerequisitesUnderflow(){
        assertThrows(IllegalArgumentException.class, () -> {
            scheduler.canFinish(2, new int[][] {{1}});
        });
    }

    @Property
    void testPropertyNumCoursesPass(
            @ForAll @IntRange(min = 1, max = 64) int numCourses
    ) {
        int[][] prerequisites = new int[][] {};
        boolean actual = scheduler.canFinish(numCourses, prerequisites);
        assertTrue(actual);
    }

    @Property
    void testPropertyNumCoursesFail(
            @ForAll("numCoursesGreaterThan64") int numCourses
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            int[][] prerequisites = new int[][] {};
            scheduler.canFinish(numCourses, prerequisites);
        });
    }

    @Provide
    Arbitrary<Integer> numCoursesGreaterThan64() {
        return Arbitraries.integers().greaterOrEqual(65);
    }

    @Property
    void testPropertyPrerequisitesPass(
            @ForAll("validPrerequisites") int[][] prerequisites
    ) {
        int numCourses = 64;
        boolean actual = scheduler.canFinish(numCourses, prerequisites);
        assertTrue(actual);
    }

    @Provide
    Arbitrary<int[][]> validPrerequisites() {
        return Arbitraries.integers().between(1, 63).map(i -> new int[][] {{i, i-1}});
    }

    @Property
    void testPropertyPrerequisitesFail(
            @ForAll("invalidPrerequisites") int[][] prerequisites
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            int numCourses = 64;
            scheduler.canFinish(numCourses, prerequisites);
        });
    }

    @Provide
    Arbitrary<int[][]> invalidPrerequisites() {
        return Arbitraries.integers().between(1, 63).map(i -> new int[][] {{i}});
    }
}
// Compare this snippet from assignment02/ArrayRotator/src/main/java/zest/ArrayRotator.jav
