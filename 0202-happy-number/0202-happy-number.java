/* Solving using slow and fast pointer */
class Solution {
    public boolean isHappy(int n) {
            // solving using slow and fast pointer;
            int slow = n;
            int fast = n;
            while(true) {
                slow = helper(slow);
                fast = helper(helper(fast));
                if(slow == 1 && fast == 1) return true;
                if(slow == fast) return false;
            }
    }
    public int helper(int n ) {
        int sum = 0;
        while(n > 0){
            int digit= n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}