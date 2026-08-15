// this is basically the count substring with at most k distinct characters the solution before it was brute force and now it is sliding window


class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            // 1. Add the current fruit from the right pointer to the map
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 2. If we have more than 2 types of fruits, shrink the window from the left
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++; // Move the left pointer forward
            }
            
            // 3. Update the maximum length of a valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}