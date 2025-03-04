package zest;

public class ConsecutiveElementsSum {
    /**
     * Calculates the maximum sum of consecutive elements in the array.
     * @param numbers the array of integers to analyze.
     * @return the maximum sum of consecutive elements.
     */
    public static int maxConsecutiveSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int maxSum = numbers[0];
        int currentSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            currentSum = Math.max(numbers[i], currentSum + numbers[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

