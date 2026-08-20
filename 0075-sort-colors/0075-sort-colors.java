class Solution{
    public void sortColors(int [] nums){
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums , low , mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1) mid++;
            else{
                swap(nums, mid , high);
                high--;
            }
        }

    }
    private void swap(int [] nums, int low , int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
// class Solution {
//     public void sortColors(int[] nums) {
//         int low = 0;
//         int high = nums.length-1;
//         int mid = 0;
//         while(mid <= high){
//             if(nums[mid] == 0) {
//                 swap(nums, mid, low );
//                 low++;
//                 mid++;
//             }
//             else if(nums[mid] == 1) mid++;
//             else{
//                 swap(nums, mid , high);
               
//                 high--;
//             }
//         }
//     }
//     private static void swap(int [] nums, int a , int b) {
//         int temp = nums[a];
//         nums[a] = nums[b];
//         nums[b] = temp;
//     }
// }