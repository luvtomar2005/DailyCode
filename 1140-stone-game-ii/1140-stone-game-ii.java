class Solution {

    int n;
    int[] suffix;
    int[][] dp;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int m = 0; m <= n; m++) {
                dp[i][m] = -1;
            }
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int totalRemaining = suffix[i];

        int best = 0;

        int maxTake = Math.min(2 * M, n - i);

        for (int X = 1; X <= maxTake; X++) {

            int newM = Math.max(M, X);

            int currentScore =
                    totalRemaining - solve(i + X, newM);

            best = Math.max(best, currentScore);
        }

        dp[i][M] = best;

        return best;
    }
}