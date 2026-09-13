class Solution {
public:
    vector<vector<int>> cyclicShift(int n, vector<vector<int>>& grid, vector<int>& rowShift, vector<int>& colShift) {
        vector<vector<int>> res;
        res = grid;
        for(int i=0; i<n; i++ ){
            for(int j = 0; j<n; j++){
                res[i][(j-rowShift[i]+n)%n] = grid[i][j];
            }
        }
        grid = res;
        for(int j=0; j<n; j++){
            for(int i=0; i<n; i++){
                res[(i-colShift[j]+n)%n][j] = grid[i][j];
            }
        }
        return res;
        
    }
};