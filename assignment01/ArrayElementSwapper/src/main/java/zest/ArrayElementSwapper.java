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

        // loop through all elements in the array
        for (int i = 0; i < numbers.length; i++) {
            // if the current element is negative
            if(numbers[i] < 0) {
                // move it to the left as long as it is not the first element
                // and the previous element is non-negative
                for (int j = i; j > 0 && numbers[j - 1] >= 0; j--) {
                    // swap the current element with the previous element
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }
}
