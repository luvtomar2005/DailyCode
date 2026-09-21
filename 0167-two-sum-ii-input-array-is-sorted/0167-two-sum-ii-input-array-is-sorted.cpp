class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int i = 0;
        int n = numbers.size() - 1;
        int j = n;
        while(i <= n && j > 0){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return {i + 1 , j + 1};
            }
            else if(sum > target) j--;
            else i++;
        }        
         return {0 , 0};
    }
   
};
