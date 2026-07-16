// Tabulation solution

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        int buyStock =
                                -prices[index]
                                        + dp[index + 1][0][cap];

                        int skip =
                                dp[index + 1][1][cap];

                        dp[index][buy][cap]
                                = Math.max(buyStock, skip);

                    } else {

                        int sell =
                                prices[index]
                                        + dp[index + 1][1][cap - 1];

                        int hold =
                                dp[index + 1][0][cap];

                        dp[index][buy][cap]
                                = Math.max(sell, hold);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}