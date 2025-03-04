package zest;

public class StringTransformer {
    public static int minOperations(String start, String target) {
        int m = start.length();
        int n = target.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                             Math.min(dp[i - 1][j], // Remove
                                                      dp[i][j - 1])); // Insert
                }
            }
        }
        return dp[m][n];
    }
}
