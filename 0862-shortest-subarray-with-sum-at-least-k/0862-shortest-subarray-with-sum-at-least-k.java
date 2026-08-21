class Solution {
    // Solving using Prefix sum + deque pattern -> codewithmik logic
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deq =new LinkedList<>();
        long [] prefixSum = new long[n];
        int result = Integer.MAX_VALUE;
        int j = 0;
        while(j < n){
            if(j == 0){
                prefixSum[j] = nums[j]; 
            }
            else{
                prefixSum[j] = prefixSum[j - 1] + nums[j];

            }
            if(prefixSum[j] >= k){
                result = Math.min(result , j + 1);
            }
            while(!deq.isEmpty() && prefixSum[j] - prefixSum[deq.peekFirst()] >= k){
                result = Math.min(result , j - deq.peekFirst()); // calculating the length of the subarray
                deq.pollFirst(); // remove the front index
            }
            //  Maintaining the montoic property of deque
            while(!deq.isEmpty() && prefixSum[j] <= prefixSum[deq.peekLast()]){
                deq.pollLast();
            }
            // Add the current index
            deq.offerLast(j);
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

