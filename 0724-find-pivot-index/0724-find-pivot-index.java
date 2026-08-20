/* Approach 1 using two array prefix + suffix sum */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int [] prefixSum = new int[n];
        int [] suffixSum = new int[n];
        // Building prefixSum
        
        for(int i = 1;i<n;i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        // Building suffix sum
        for(int i = n -2;i>=0;i--){
            suffixSum[i] = suffixSum[i + 1] + nums[i + 1];
        }
        // Finding the equal element
        for(int i = 0;i<n;i++){
            if(prefixSum[i] == suffixSum[i]){
                return i;
            }
        }
        return -1;
    }
}