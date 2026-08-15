/* The logic is simple as the same logic as maximum length of substring with k distinct character..  */
class Solution {
    public int totalFruit(int[] fruits) {
        int left =0;
        int maxFruits = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0;right < fruits.length;right++) {
            map.put(fruits[right] , map.getOrDefault(fruits[right] , 0)  + 1);

            if(map.size()  > 2){
                map.put(fruits[left] , map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits , right - left + 1);
        }
        return maxFruits;
    }
}