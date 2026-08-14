class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {

        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            product *= arr[right];

            while (product >= k) {
                product /= arr[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}