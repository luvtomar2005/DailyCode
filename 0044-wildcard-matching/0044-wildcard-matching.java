class Solution {
    public boolean isMatch(String s, String p) {
        // solving using memoization
        int n = s.length();
        int m = p.length();
        int [][] dp = new int[n + 1][m + 1];
        for(int [] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(0 , 0 , s , p , dp);
    }
    private boolean solve(int i , int j , String s , String p , int [][] dp){
        if(i == s.length() && j == p.length()) return true;
        if(j == p.length()) return false;
        if(i == s.length()){
            while(j < p.length()){
                if(p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j]  == 1;
        boolean ans;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            ans = solve(i + 1 , j + 1 , s , p ,dp);
        }
        else if(p.charAt(j) == '*'){
            ans = solve(i , j + 1 , s , p , dp) || solve(i + 1 , j , s , p, dp);
        }
        else{
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}       
