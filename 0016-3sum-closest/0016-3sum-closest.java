class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - closestSum ) > Math.abs(target - sum)){
                    closestSum = sum;
                }
                else if(sum > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return closestSum;
    }
}