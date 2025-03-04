package zest;

public class ArrayElementSwapper {
    /**
     * Rearranges the elements of the given array such that all negative numbers
     * come before all non-negative numbers, while preserving the order of negative
     * and non-negative numbers within their groups.
     * @param numbers the array of integers to be rearranged.
     */
    public static void swapElements(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        // First pass: count negative numbers to determine the boundary of negatives and non-negatives
        int negativeCount = 0;
        for (int num : numbers) {
            if (num < 0) {
                negativeCount++;
            }
        }

        // Use two pointers to reposition elements, preserving internal order
        int[] temp = new int[numbers.length];  // Temporary array to hold rearranged elements
        int negIndex = 0;  // Pointer for placing negatives
        int nonNegIndex = negativeCount;  // Pointer for placing non-negatives

        for (int num : numbers) {
            if (num < 0) {
                temp[negIndex++] = num;
            } else {
                temp[nonNegIndex++] = num;
            }
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(temp, 0, numbers, 0, numbers.length);
    }
}
