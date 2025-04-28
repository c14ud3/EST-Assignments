package zest;

import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Size;

class ZerosToEndTest {
    @Test
    void testBasicCase() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 2, 0, 4, 3, 0, 5, 0};
        int[] expected = {1, 2, 4, 3, 5, 0, 0, 0};
        assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    }

    @Test
    void testAllZeros() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    }

    @Test
    void testNoZeros() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    }

    @Test
    void testEmptyArray() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    }
    // The following test is outcommented, because this now returns an error message and is replaced by a precondition test.
    //@Test
    //void testArrayExceedingSizeConstraint() {
    //    ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
    //    int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    //    int[] expected = {};
    //    assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    //}

    @Test
    void testArrayWithExactly10Elements() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0};
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, zeroesToEnd.pushZeroesToEnd(input));
    }

    //Preconditions tests
    @Test
    void testPreconditions_NullArray() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            zeroesToEnd.pushZeroesToEnd(input);
        });
        assertEquals("Input array cannot be null", exception.getMessage());
    }

    @Test
    void testPreconditions_ArrayExceedingSize() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            zeroesToEnd.pushZeroesToEnd(input);
        });
        assertEquals("Input array must have at most 10 elements", exception.getMessage());
    }

    //Postconditions tests
    @Test
    void testPostconditions_ResultNotNull() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0};
        int[] result = zeroesToEnd.pushZeroesToEnd(input);
        assertNotNull(result, "Result array cannot be null");
    }

    @Test
    void testPostconditions_ResultSizeWithinBounds() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0};
        int[] result = zeroesToEnd.pushZeroesToEnd(input);
        assertTrue(result.length <= 10, "Result array must have at most 10 elements");
    }

    //Invariants tests
    @Test
    void testInvariants_LengthUnchanged() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0};
        int[] result = zeroesToEnd.pushZeroesToEnd(input);
        assertEquals(input.length, result.length, "Input and result arrays must have the same length");
    }

    @Test
    void testInvariants_SameNonZeroElements() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0};
        int[] result = zeroesToEnd.pushZeroesToEnd(input);
        int[] expectedNonZero = {1, 2};
        int[] actualNonZero = java.util.Arrays.stream(result).filter(x -> x != 0).toArray();
        assertArrayEquals(expectedNonZero, actualNonZero, "Non-zero elements must retain their order");
    }

    @Test
    void testInvariants_SameNumberOfZeros() {
        ZeroesToEnd zeroesToEnd = new ZeroesToEnd();
        int[] input = {1, 0, 2, 0};
        int[] result = zeroesToEnd.pushZeroesToEnd(input);
        long inputZeroCount = java.util.Arrays.stream(input).filter(x -> x == 0).count();
        long resultZeroCount = java.util.Arrays.stream(result).filter(x -> x == 0).count();
        assertEquals(inputZeroCount, resultZeroCount, "Number of zeros in input and result arrays must match");
    }



}

class ZerosToEndPropertyTest {

    // Create an instance of ZeroesToEnd for testing
    ZeroesToEnd zeroesToEnd = new ZeroesToEnd();

    // ---------------------------------------------------------------------------------------------------------------

    // Test for checking the property that all zeroes must be moved to the end
    @Property
    void testZerosMovedToEnd(
            @ForAll("arrayWithAtLeastOneZero") // get the array with at least one zero
            int[] input) {

        int[] result = zeroesToEnd.pushZeroesToEnd(input); // execute the method under test

        // Check that all zero elements are at the end of the result array
        boolean zerosStarted = false;
        for (int value : result) {
            if (value == 0) {
                zerosStarted = true; // this flag is set to true once the first zero appears
            } else { // if we encounter a non-zero element after the first zero, the test should fail
                assertFalse(zerosStarted, "Non-zero element found after zeros in result array");
            }
        }
    }

    // Provide an array that ensures to include at least one zero at a random index and has a maximum size of 10 and a minimum size of 1
    @Provide
    Arbitrary<int[]> arrayWithAtLeastOneZero() {
        return Arbitraries.integers()
                .list()// transform the array to a list
                .ofMinSize(1).ofMaxSize(10) // Array size between 1 and 10
                .map(list -> {
                    int insertAt = Arbitraries.integers().between(0, list.size()-1).sample(); // generate random index to overwrite to zero
                    list.set(insertAt, 0); // overwrite to zero
                    return list.stream().mapToInt(Integer::intValue).toArray(); // transform the list to an array again
                });
    }

    //---------------------------------------------------------------------------------------------------------------

    // Test for checking the property that the order of non-zero elements is preserved
    @Property
    void testNonZeroOrderPreserved(
            @ForAll // we need an array with random integers of max size 10, so no provider is required for that
            @Size(max = 10)
            int[] input) {

        int[] result = zeroesToEnd.pushZeroesToEnd(input); // execute the method under test

        // Now we remove all zeros from both the input and the output array
        int[] nonZeroInput = java.util.Arrays.stream(input).filter(x -> x != 0).toArray();
        int[] nonZeroResult = java.util.Arrays.stream(result).filter(x -> x != 0).toArray();

        // Now we can compare the arrays. If they are equal, the order is preserved and the test passes.
        assertArrayEquals(nonZeroInput, nonZeroResult, "Order of non-zero elements is not preserved");
    }

    //---------------------------------------------------------------------------------------------------------------

    // Test for checking the property that the number of zeros in the result array matches the number of zeros in the input array
    @Property
    void testSameNumberOfZeros(
            @ForAll // we make an array that includes only zeros and 1s to increase the likelihood that many zeros are included in the array.
            @Size(max = 10)
            @IntRange(min = 0, max = 1)
            int[] input) {

        int[] result = zeroesToEnd.pushZeroesToEnd(input); // execute the method under test

        // Count the number of zeros in both the input and result arrays
        long inputZeroCount = java.util.Arrays.stream(input).filter(x -> x == 0).count(); // for some reason the count() method returns long and not int
        long resultZeroCount = java.util.Arrays.stream(result).filter(x -> x == 0).count();

        // Check that the number of zeros in the input and result arrays is the same
        assertEquals(inputZeroCount, resultZeroCount, "Number of zeros in input and result arrays do not match");
    }


}
