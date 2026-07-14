class Solution {
    // solving using tabulation

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[index][buy]
        //
        // buy = 1
        // I don't own a stock.
        // I can BUY.
        //
        // buy = 0
        // I already own a stock.
        // I can SELL or HOLD.
        int[][] dp = new int[n + 1][2];

        // Base Case:
        // After the last day,
        // no profit can be earned.
        dp[n][0] = 0;
        dp[n][1] = 0;

        // Fill from last day to first day.
        for (int index = n - 1; index >= 0; index--) {

            // ============================
            // buy == 1
            // I have permission to BUY
            // ============================

            // Buy today's stock.
            int buyStock =
                    -prices[index] + dp[index + 1][0];

            // Skip today's buying.
            int skipBuying =
                    dp[index + 1][1];

            dp[index][1] =
                    Math.max(buyStock, skipBuying);

            // ============================
            // buy == 0
            // I already own a stock.
            // Choices:
            // Sell OR Hold
            // ============================

            // Sell today's stock.
            int sellStock =
                    prices[index] + dp[index + 1][1];

            // Don't sell.
            // Continue holding.
            int holdStock =
                    dp[index + 1][0];

            dp[index][0] =
                    Math.max(sellStock, holdStock);
        }

        // Start from day 0.
        // Initially we own nothing,
        // so we have permission to BUY.
        return dp[0][1];
    }
}