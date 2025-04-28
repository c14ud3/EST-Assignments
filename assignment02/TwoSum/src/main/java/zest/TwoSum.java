package zest;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findTwoSum(int[] nums, int target) {

        // check preconditions
        checkPreconditions(nums, target);
        int length = nums.length;

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                // Post-condition checks
                int[] result = new int[]{numMap.get(complement), i};
                if (result[0] != result[1] && result[0] >= 0 && result[1] >= 0 && result[0] < nums.length && result[1] < nums.length) {

                    // checkPostconditions
                    checkPostconditions(result, length);

                    return result;
                }
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    void checkPreconditions(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements");
        }
        // check for duplicate elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    throw new IllegalArgumentException("Input array contains duplicate elements");
                }
            }
        }
    }

    void checkPostconditions(int[] result, int length) {
        if (result == null) {
            throw new IllegalStateException("Result array cannot be null");
        }
        if (result.length != 2) {
            throw new IllegalStateException("Result array must have exactly two elements");
        }
        if (result[0] == result[1]) {
            throw new IllegalStateException("Result indices must be different");
        }
        if (result[0] >= length || result[1] >= length) {
            throw new IllegalStateException("Result indices must be within the bounds of the input array");
        }
    }

}
