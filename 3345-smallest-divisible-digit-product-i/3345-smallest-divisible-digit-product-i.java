class Solution {
    public int smallestNumber(int n, int t) {
        while(true) {
            if(isDivisible(n , t)) return n;
            n++;
        }
    }
    private boolean isDivisible(int num, int t){
        int product = 1;
        while(num > 0){
            int digit = num % 10;
            product *= digit;
            if(product == 0) return true;
            num /= 10;
        }
        return product % t == 0;
    }
}



   