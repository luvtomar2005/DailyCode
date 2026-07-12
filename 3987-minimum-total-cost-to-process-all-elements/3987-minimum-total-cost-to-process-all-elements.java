class Solution{
    public int minimumCost(int[] A, int k) {
        // greedy + strong mathematical observation
        long s = 0, mod = 1000000007;
        for (int a : A)
            s += a;
        long x = (s + k - 1) / k % mod;
        return (int) ((x - 1) * x / 2 % mod);
    }
}