class Solution{
    public int maxProfit(int [] prices){
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int price : prices){
            minPrice = Math.min(minPrice , price);
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit  , currentProfit);
        }
        return maxProfit;
    }
}
