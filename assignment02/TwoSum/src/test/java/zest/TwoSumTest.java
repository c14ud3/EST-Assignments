package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Size;

class TwoSumTest {
    @Test
    void testBasicCase() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.findTwoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testNegativeNumbers1() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] result = twoSum.findTwoSum(nums, target);
        assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test
    void testNegativeNumbers2() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {-7, -4, -3, 90};
        int target = -7;
        int[] result = twoSum.findTwoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testDontUseTwice() { // checks that the algorithm doesn't use 3 twice to get 6, but instead uses 2 and 4.
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum.findTwoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testNoSolution() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 2, 3};
        int target = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSum.findTwoSum(nums, target);
        });
        assertEquals("No two sum solution", exception.getMessage());
    }

    // Preconditions tests
    @Test
    void testPreconditions_NullArray() {
        TwoSum twoSum = new TwoSum();
        int[] nums = null;
        int target = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSum.findTwoSum(nums, target);
        });
        assertEquals("Input array cannot be null", exception.getMessage());
    }

    @Test
    void testPreconditions_EmptyArray() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {};
        int target = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSum.findTwoSum(nums, target);
        });
        assertEquals("Input array must have at least two elements", exception.getMessage());
    }

    @Test
    void testPreconditions_DuplicateElements() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 2, 2, 3};
        int target = 4;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSum.findTwoSum(nums, target);
        });
        assertEquals("Input array contains duplicate elements", exception.getMessage());
    }

    // Postconditions tests
    @Test
    void testPostconditions_ResultNotNull() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.findTwoSum(nums, target);
        assertNotNull(result, "Result array cannot be null");
    }

    @Test
    void testPostconditions_ResultHasTwoElements() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.findTwoSum(nums, target);
        assertEquals(2, result.length, "Result array must have exactly two elements");
    }

    @Test
    void testPostconditions_ResultIndicesDistinct() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 8, 11, 15};
        int target = 10;
        int[] result = twoSum.findTwoSum(nums, target);
        assertNotEquals(result[0], result[1], "Result indices must be different");
    }

    @Test
    void testPostconditions_ResultIndicesWithinBounds() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.findTwoSum(nums, target);
        assertTrue(result[0] >= 0 && result[0] < nums.length, "Result indices must be within bounds");
        assertTrue(result[1] >= 0 && result[1] < nums.length, "Result indices must be within bounds");
    }

}

class TwoSumPropertyTest {

    // Create an instance of the TwoSum class to be tested
    TwoSum twoSum = new TwoSum();

    @Property
    void testTwoSumWithValidInputs(
            @ForAll("distinctIntArray") // provide an array of distinct integers
            int[] nums,
            @ForAll // provide a random integer
            @Size(min = -50, max = 50) // ensure the target is within a reasonable range to increase the likelihood that a pair is found
            int target) {

        // We know that the method could return an error if no two numbers sum to the target. So we use Try-Catch to handle that.
        try {
            int[] result = twoSum.findTwoSum(nums, target); // Call the method under test
            // Validate the result
            // check that the length of the result array is 2
            assertEquals(2, result.length, "Result array must have exactly two elements");
            // Check if the indices in the result array are valid indices of the input array
            for (int index : result) {
                assertTrue(index >= 0 && index < nums.length, "Result indices must be within the bounds of the input array");
            }
            // Check if the values of the two returned indices sum up to the target
            assertEquals(nums[result[0]] + nums[result[1]], target, "Sum of elements at result indices must equal the target");
            // Check if the two returned indices are distinct
            assertNotEquals(result[0], result[1], "Result values must be distinct");

        } catch (Exception e) {
            // We validate that the exception type and message is correct
            assertTrue(e instanceof IllegalArgumentException, "No two sum solution");
            // If this exception is thrown, we can assume that no valid pair was found
            // This is acceptable behavior

        }
    }

    @Provide
    Arbitrary<int[]> distinctIntArray() {
        return Arbitraries.integers()
                .between(-50, 50) // we limit the range such that it's more likely that the random generated input results in a solution
                .set()// create a set of integers, because a set contains distinct integers and we need that property
                .ofMinSize(2) // minimum size must be 2 according to the specification
                .ofMaxSize(100)
                .map(set -> set.stream().mapToInt(Integer::intValue).toArray()); // we convert the set to an array as needed
    }
}