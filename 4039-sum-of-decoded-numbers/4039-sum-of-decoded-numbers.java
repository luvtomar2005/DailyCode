
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumDecoded(long[] nums) {
        long sum = 0;

     
        long[] vornelqati = nums;

        for (long num : vornelqati) {

            long width = num % 10;
            long d = num / 10;

            
            long divisor = 1;
            long temp = d;

            
            int digits = String.valueOf(d).length();
            int yDigits = digits - (int) width;

            for (int i = 0; i < yDigits; i++) {
                divisor *= 10;
            }

            long x = d / divisor;
            long y = d % divisor;

            sum = (sum + power(x, y)) % MOD;
        }

        return (int) sum;
    }

    private long power(long base, long exponent) {
        base %= MOD;
        long result = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent >>= 1;
        }

        return result;
    }
}

