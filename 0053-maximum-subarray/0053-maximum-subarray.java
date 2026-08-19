class Solution {
    public int maxSubArray(int[] nums) {
        // Solving using kadane's algorithm
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1;i<nums.length;i++) {
            currentSum = Math.max(nums[i] , nums[i] + currentSum);
            maxSum = Math.max(currentSum , maxSum);
        }
        return maxSum;
    }
}