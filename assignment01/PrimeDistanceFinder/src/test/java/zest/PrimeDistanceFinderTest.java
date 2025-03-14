package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

class PrimeDistanceFinderTest {
    @Test // test case 1
    void testEmptyArray() {
        int[] input = {};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 2
    void testSinglePrime() {
        int[] input = {2};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 3
    void testSingleNonPrime() {
        int[] input = {4};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 4
    void testMultipleIntegersFirstPrime() {
        int[] input = {2, 4, 6, 8};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 5
    void testMultipleIntegersLastPrime() {
        int[] input = {4, 6, 8, 2};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 6
    void testMultipleIntegersRandomPrime() {
        int[] input = {4, 2, 6, 8};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 7
    void testMultipleIntegersNoPrimes() {
        int[] input = {4, 6, 8, 10};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 8
    void testTwoPrimesAscending() {
        int[] input = {2, 3};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 9
    void testMoreThanTwoNumbersTwoPrimesSmallerFirst() {
        int[] input = {2, 4, 6, 3};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 10
    void testTwoPrimesDescending() {
        int[] input = {3, 2};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 11
    void testMoreThanTwoNumbersTwoPrimesSmallerLast() {
        int[] input = {4, 6, 3, 2};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 12
    void testTwoIdenticalPrimes() {
        int[] input = {3, 3};
        int expected = 0;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 13
    void testMoreThanTwoPrimesAscending() {
        int[] input = {2, 3, 5, 7};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 14
    void testMoreThanTwoPrimesDescending() {
        int[] input = {7, 5, 3, 2};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 15
    void testMoreThanTwoPrimesRandomSmallestDiffFirstSecond() {
        int[] input = {2, 3, 11, 17};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 16
    void testMoreThanTwoPrimesRandomSmallestDiffLastSecondLast() {
        int[] input = {11, 17, 2, 3};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 17
    void testMoreThanTwoPrimesRandomSmallestDiffFirstLast() {
        int[] input = {2, 11, 17, 3};
        int expected = 1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 18
    void testMoreThanTwoPrimesAllSameDistance() {
        int[] input = {7, 11, 13, 5, 3};
        int expected = 2;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 19
    void testMoreThanTwoPrimesNegativeNumbers() {
        int[] input = {-100, 3, 5, 100, 0, -3};
        int expected = 2;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 19
    void testMoreThanTwoPrimesIncludingNumberOne() {
        int[] input = {1, 3, 100};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }

    @Test // test case 19
    void testOnlyNegativeNumbers() {
        int[] input = {-100, -3, -5};
        int expected = -1;
        assertEquals(expected, PrimeDistanceFinder.findSmallestPrimeDistance(input));
    }
 
}