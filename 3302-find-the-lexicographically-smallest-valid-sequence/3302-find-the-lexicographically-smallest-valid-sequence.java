class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suffix[i] = smallest index in word2
        // that still needs matching if starting from word1[i]
        int[] suffix = new int[n + 1];

        suffix[n] = m;

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && word1.charAt(i) == word2.charAt(j))
                j--;

            suffix[i] = j + 1;
        }

        int[] ans = new int[m];

        int p = 0;

        boolean used = false;

        for (int i = 0; i < n && p < m; i++) {

            if (word1.charAt(i) == word2.charAt(p)) {

                ans[p++] = i;

            } else if (!used) {

                // Can remaining suffix still match?
                if (suffix[i + 1] <= p + 1) {

                    used = true;

                    ans[p++] = i;
                }
            }
        }

        if (p != m)
            return new int[0];

        return ans;
    }
}