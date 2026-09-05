// Monotonic stack solution got from leetcode solutions
class Solution{
    public int [] nextGreaterElement(int [] nums1 , int [] nums2){
        int [] nextGreaterElement = new int[10001];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            nextGreaterElement[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        for(int i = 0;i<nums1.length;i++){
            nums1[i] = nextGreaterElement[nums1[i]];
        }
        return nums1;
    }
}

