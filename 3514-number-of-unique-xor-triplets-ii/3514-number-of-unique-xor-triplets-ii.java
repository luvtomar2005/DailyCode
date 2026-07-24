import java.util.*;

class Solution {

    public int uniqueXorTriplets(int[] nums) {

        final int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];

        dp[0][0] = true;

        // Since repetition is allowed (i <= j <= k),
        // perform 3 rounds of transitions.
        for (int step = 0; step < 3; step++) {

            boolean[] next = Arrays.copyOf(dp[step + 1], MAX);

            for (int xor = 0; xor < MAX; xor++) {

                if (!dp[step][xor])
                    continue;

                for (int num : nums) {

                    next[xor ^ num] = true;
                }
            }

            dp[step + 1] = next;
        }

        int ans = 0;

        for (boolean possible : dp[3]) {
            if (possible)
                ans++;
        }

        return ans;
    }
}