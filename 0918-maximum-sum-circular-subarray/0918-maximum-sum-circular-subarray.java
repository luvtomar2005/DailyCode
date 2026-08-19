// Using two kadane's algorithm method
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;
        for(int num : nums) {
            currentMax = Math.max(num , currentMax + num);
            maxSum = Math.max(currentMax, maxSum);
            currentMin = Math.min(num , currentMin + num);
            minSum = Math.min(currentMin , minSum);

            totalSum += num;   
        } 
        // IF all elements are negative
         if(maxSum  < 0){
                return maxSum;
        }      
            return Math.max(maxSum , totalSum - minSum);
    }
}
