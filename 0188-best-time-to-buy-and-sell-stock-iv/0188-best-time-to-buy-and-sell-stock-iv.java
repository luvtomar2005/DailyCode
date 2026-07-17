//  Solving using memoization

class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        // Start from day 0.
        // Initially we own no stock,
        // so buy = 1.
        // We still have k transactions remaining.
        return solve(0, 1, k, prices, dp);
    }

    private int solve(int index,
                      int buy,
                      int cap,
                      int[] prices,
                      int[][][] dp) {

        // No days left OR
        // No transactions left.
        if (index == prices.length || cap == 0)
            return 0;

        if (dp[index][buy][cap] != -1)
            return dp[index][buy][cap];

        if (buy == 1) {

            // Option 1:
            // Buy today.
            int buyStock =
                    -prices[index]
                            + solve(index + 1,
                                    0,
                                    cap,
                                    prices,
                                    dp);

            // Option 2:
            // Skip buying.
            int skip =
                    solve(index + 1,
                          1,
                          cap,
                          prices,
                          dp);

            return dp[index][buy][cap]
                    = Math.max(buyStock, skip);

        } else {

            // Option 1:
            // Sell today.
            // Transaction completes here.
            int sell =
                    prices[index]
                            + solve(index + 1,
                                    1,
                                    cap - 1,
                                    prices,
                                    dp);

            // Option 2:
            // Continue holding.
            int hold =
                    solve(index + 1,
                          0,
                          cap,
                          prices,
                          dp);

            return dp[index][buy][cap]
                    = Math.max(sell, hold);
        }
    }
}