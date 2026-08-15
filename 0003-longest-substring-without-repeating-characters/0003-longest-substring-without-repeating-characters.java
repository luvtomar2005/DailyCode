class Solution {
    // Same logic of hashmap and sliding window which we have used in fruits into basket
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right = 0; right < s.length();right++) {
            char ch = s.charAt(right);
            map.put(ch , map.getOrDefault(ch , 0 ) + 1);

            while(map.get(ch) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar , map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen , right - left + 1);
        }
        return maxLen;
    }
}