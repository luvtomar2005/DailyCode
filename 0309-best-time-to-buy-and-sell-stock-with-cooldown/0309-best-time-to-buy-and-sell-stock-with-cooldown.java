//  Memoization solution 
class Solution {
    public int maxProfit(int [] prices){
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int [] row : dp ){
            Arrays.fill(row , -1);
        }
        return solve(0 , 1 , prices , dp);
    }
    private int solve(int index, int buy, int [] prices, int [][] dp){
        // No day left
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1) {
            // option 1 : buy today
            int buyStock = -prices[index] + solve(index + 1 , 0 , prices, dp);
            // option 2 : skip buying\
            int skip = solve(index + 1 , 1 ,prices, dp );
            return dp[index][buy] = Math.max(buyStock , skip);
        }
        else{
            // option 1 : sell today
            // next day is cooldown
            int sell = prices[index] + solve(index + 2 , 1, prices, dp);
            // option 2 : hold stock
            int hold = solve(index + 1 , 0 , prices, dp);

            return dp[index][buy] = Math.max(sell , hold);
        }
    }
}

//             return dp[index][buy]
//                     = Math.max(sell, hold);
//         }
//     }
// }