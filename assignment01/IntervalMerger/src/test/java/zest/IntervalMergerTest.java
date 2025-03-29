package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class IntervalMergerTest {
    @Test
    void testEmptyList() {
        int[][] intervals = {};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{}, result);
    }

    @Test
    void testEmtpyInterval(){
        int[][] intervals = {{}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{}}, result);
    }

    @Test
    void testMultipleEmptyIntervals(){
        int[][] intervals = {{}, {}, {}};
        assertThrows(ArrayIndexOutOfBoundsException.class , () -> IntervalMerger.mergeIntervals(intervals));
    }

    @Test
    void testOneInterval(){
        int[][] intervals = {{1, 2}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 2}}, result);
    }

    @Test
    void testTwoOverlappingIntervals(){
        int[][] intervals = {{1, 3}, {2, 4}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 4}}, result);
    }

    @Test
    void testTwoNotOverlappingIntervals(){
        int[][] intervals = {{1,2}, {3,4}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1,2}, {3,4}}, result);
    }

    @Test
    void testMultipleOverlappingIntervals(){
        int[][] intervals = {{1,3}, {2,5}, {4,8}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1,8}}, result);
    }

    @Test
    void testMultipleNotOverlappingIntervals(){
        int[][] intervals = {{1,2}, {3,4}, {5,6}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1,2}, {3,4}, {5,6}}, result);
    }

    @Test
    void testSameInterval(){
        int[][] intervals = {{1, 2}, {1, 2}};
        int[][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 2}}, result);
    }

    @Test
    void testNonOverlappingIntervalsWithNegativeValues(){
        int[][] intervals = {{-8, -6}, {-5, -2}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{-8, -6}, {-5, -2}}, result);
    }

    @Test
    void testOverlappingIntervalsWithNegativeValues(){
        int[][] intervals = {{-8, -6}, {-7, -4}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{-8, -4}}, result);
    }

    @Test
    void testUnsortedNonOVerlap(){
        int[][] intervals = {{8, 15}, {2, 5}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{2, 5}, {8, 15}}, result);
    }

    @Test
    void testUnsortedOverlap(){
        int[][] intervals = {{8, 15}, {2, 9}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{2, 15}}, result);
    }

    @Test
    void testOneDigitIntervals(){
        int[][] intervals = {{1, 1}, {2, 2}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 1}, {2, 2}}, result);
    }

    @Test
    void testOneDigit(){
        int[][] intervals = {{1}};
        int [][] result = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1}}, result);
    }

    @Test
    void testOneEmptyInterval(){
        int[][] intervals = {{1, 2}, {}};
        assertThrows(ArrayIndexOutOfBoundsException.class , () -> IntervalMerger.mergeIntervals(intervals));
    }

    @Test
    void testInvalidIntervals(){
        int[][] intervals = {{1, 2}, {2, 1}};
        int[][] result  = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 2}}, result);
    }

    @Test
    void testMultipleInvalidIntervals(){
        int[][] intervals = {{1, 4}, {3, -1}, {2, 6}};
        int[][] result  = IntervalMerger.mergeIntervals(intervals);
        assertArrayEquals(new int[][]{{1, 6}}, result);
    }








}