package zest;

public class ClimbingStairs {

    /**
     * Computes the number of ways to climb 'n' stairs, where each step you can either climb 1 or 2 steps.
     *
     * @param n The number of stairs to climb.
     * @return The number of distinct ways to climb to the top.
     */
    public long climbStairs(int n) {
        
        // Base cases handling
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        long oneStepBefore = 2;  // Represents the number of ways to reach the second-to-last step.
        long twoStepsBefore = 1; // Represents the number of ways to reach the third-to-last step.
        long allWays = 0;

        for (int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }

        return allWays;
    }
}
