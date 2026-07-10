class Solution {
    // Memoization solution

    int[][] dp;

    private int f(int i, int j, String s, String t) {

        // Target completed
        if (j < 0)
            return 1;

        // Source exhausted
        if (i < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {

            return dp[i][j] =
                    f(i - 1, j - 1, s, t)
                  + f(i - 1, j, s, t);

        }

        return dp[i][j] = f(i - 1, j, s, t);
    }

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(s.length() - 1, t.length() - 1, s, t);
    }
}