class Solution {
    public int maxProfit(int[] prices, int fee) {
        // Solving using memoizaiton
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int [] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(0 , 1 , prices, fee, dp);
    }
    private int solve(int index, int buy , int [] prices, int fee , int [][] dp){
        if(index == prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1){
            int buyStock = -prices[index] + solve(index + 1  , 0 , prices , fee, dp);
            int skipBuying = solve(index + 1 , 1 , prices, fee, dp);
            return dp[index][buy] = Math.max(buyStock , skipBuying);

        }
        else{
            int sell = prices[index] - fee + solve(index + 1 , 1, prices, fee, dp);

            int hold = solve(index + 1 , 0 , prices , fee, dp);
            return dp[index][buy] = Math.max(sell , hold);
        }
    }
}
