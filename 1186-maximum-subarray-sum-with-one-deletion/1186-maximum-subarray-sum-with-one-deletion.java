class Solution {

    public int maximumSum(int[] arr) {

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int newNoDelete =
                Math.max(arr[i], noDelete + arr[i]);

            int newOneDelete =
                Math.max(noDelete,
                         oneDelete == Integer.MIN_VALUE
                         ? Integer.MIN_VALUE
                         : oneDelete + arr[i]);

            noDelete = newNoDelete;
            oneDelete = newOneDelete;

            maxSum = Math.max(maxSum, noDelete);
            maxSum = Math.max(maxSum, oneDelete);
        }

        return maxSum;
    }
}