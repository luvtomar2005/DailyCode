/* The logic is simple as the same logic as maximum length of substring with k distinct character..  */
class Solution{
    public int totalFruit(int [] nums){
        int left = 0;
        int maxFruits = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0;right < nums.length;right++){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);
            while(map.size() > 2){
                map.put(nums[left] , map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                    
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}
