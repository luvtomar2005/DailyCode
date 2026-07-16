class Solution {
    // solving using memoizatoin
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from day 0.
        // Initially we don't own any stock,
        // so we have permission to BUY.
        return solve(0, 1, prices, dp);
    }

    private int solve(int index, int buy, int[] prices, int[][] dp) {

        // No days left.
        if (index == prices.length)
            return 0;

        if (dp[index][buy] != -1)
            return dp[index][buy];

        // ------------------------------------------
        // buy == 1
        // Means:
        // I DON'T own any stock.
        // I have permission to BUY.
        // ------------------------------------------
        if (buy == 1) {

            // OPTION 1:
            // Buy today's stock.
            // Money goes out of pocket,
            // so subtract today's price.
            int buyStock =
                    -prices[index]
                            + solve(index + 1, 0, prices, dp);

            // OPTION 2:
            // Don't buy anything today.
            // Just move to next day with same permission.
            int skipBuying =
                    solve(index + 1, 1, prices, dp);

            // Take whichever gives more profit.
            return dp[index][buy] =
                    Math.max(buyStock, skipBuying);
        }

        // ------------------------------------------
        // buy == 0
        // Means:
        // I ALREADY own one stock.
        // Therefore I CANNOT buy.
        //
        // Choices:
        // Sell
        // OR
        // Keep holding
        // ------------------------------------------
        else {

            // OPTION 1:
            // Sell today's stock.
            // Money comes into pocket,
            // so add today's price.
            int sellStock =
                    prices[index]
                            + solve(index + 1, 1, prices, dp);

            // OPTION 2:
            // Don't sell.
            // Continue holding the stock.
            int holdStock =
                    solve(index + 1, 0, prices, dp);

            // Best of selling or holding.
            return dp[index][buy] =
                    Math.max(sellStock, holdStock);
        }
    }
}